package com.example.imageproject.fragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.imageproject.App
import com.example.imageproject.R
import com.example.imageproject.databinding.FragmentImageDetailBinding
import com.example.imageproject.room.SavedImage
import com.example.imageproject.room.SavedImageDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ImageDetailFragment : Fragment() {

    private lateinit var binding: FragmentImageDetailBinding

    private lateinit var savedImageDao: SavedImageDao
    var targetImageViewId: Int? = null
    private var lastImageOrder: Int = 0
    private val PERMISSION_REQUEST_CODE = 101

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        savedImageDao = (requireActivity().application as App).database.savedImageDao()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img = arguments?.getInt("img") ?: 0
        if (img != 0) {
            binding.img.setImageResource(img)
        }

        binding.img.setOnClickListener {
            val fullscreenImageFragment = FullscreenImageFragment()
            val args = Bundle()
            args.putInt("img", img)
            fullscreenImageFragment.arguments = args

            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fr_contaner, fullscreenImageFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.imgBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.imgSave.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                // Запрашиваем разрешение
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    PERMISSION_REQUEST_CODE
                )
            } else {
                saveImageToStorage(img)
            }
        }
    }

    private fun saveImageToStorage(imageResourceId: Int) {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {

            val imageBitmap: Bitmap? = (binding.img.drawable as? BitmapDrawable)?.bitmap

            val directory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyAppImages")
            if (!directory.exists()) {
                directory.mkdirs()
            }

            val fileName = "my_image_${System.currentTimeMillis()}.jpg"
            val imageFile = File(directory, fileName)

            val fos = FileOutputStream(imageFile)
            imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.close()

            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            mediaScanIntent.data = Uri.fromFile(imageFile)
            requireContext().sendBroadcast(mediaScanIntent)

            val savedImage = SavedImage(
                imageResourceId = imageResourceId,
                targetImageViewId = targetImageViewId ?: 0,
                order = lastImageOrder + 1
            )

            GlobalScope.launch(Dispatchers.IO) {
                savedImageDao.insert(savedImage)
                lastImageOrder = savedImage.order
            }

            Toast.makeText(requireContext(), getString(R.string.image_save), Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(requireContext(), getString(R.string.permission_not_granted), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Разрешение получено, можно сохранять изображение
                saveImageToStorage(arguments?.getInt("img") ?: 0)
            } else {
                // Разрешение не получено
                Toast.makeText(requireContext(), getString(R.string.permission_not_granted), Toast.LENGTH_SHORT).show()
            }
        }
    }
}