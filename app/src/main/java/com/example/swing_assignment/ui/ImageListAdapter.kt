package com.example.swing_assignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swing_assignment.data.model.ImageDataModel
import com.example.swing_assignment.databinding.ImageItemBinding

class ImageListAdapter () : ListAdapter<ImageDataModel, ImageListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ImageDataModel>() {
        override fun areItemsTheSame(oldItem: ImageDataModel, newItem: ImageDataModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ImageDataModel, newItem: ImageDataModel): Boolean {
            return oldItem == newItem
        }
    }
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ImageDataModel) = with(binding) {
            ivImage.setImageResource(item.imageUrl)
        }
    }
}