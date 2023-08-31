/*
package com.example.imageproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HomeModel
import com.example.imageproject.databinding.ItemButtonBinding

class HomeButtonAdapter(val onClick:(HomeModel)->Unit):ListAdapter<HomeModel, HomeButtonAdapter.ButtonViewHolder>(ButtonDiff()) {


    inner class ButtonViewHolder(val binding:ItemButtonBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel) {
            binding.btn.text = model.title
            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(ItemButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ButtonDiff:DiffUtil.ItemCallback<HomeModel>() {
    override fun areItemsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem == newItem
    }

}
*/
