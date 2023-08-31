/*
package com.example.imageproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.domain.model.HomeImageModel
import com.example.domain.model.HomeModel
import com.example.imageproject.databinding.ItemButtonBinding
import com.example.imageproject.databinding.ItemImgBinding

class HomeImageAdapter(val onClick:(HomeImageModel)->Unit):
    ListAdapter<HomeImageModel, HomeImageAdapter.ImageViewHolder>(ImageDiff()) {


    inner class ImageViewHolder(val binding: ItemImgBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeImageModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imageView1)
            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ImageDiff: DiffUtil.ItemCallback<HomeImageModel>() {
    override fun areItemsTheSame(oldItem: HomeImageModel, newItem: HomeImageModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeImageModel, newItem: HomeImageModel): Boolean {
        return oldItem == newItem
    }

}
*/
