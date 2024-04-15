package com.example.swing_assignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.swing_assignment.data.model.RetrofitDataModel
import com.example.swing_assignment.databinding.ImageItemBinding

class ImagePagingDataAdapter : PagingDataAdapter<RetrofitDataModel.Result, ImagePagingDataAdapter.PictureViewHolder>(object : DiffUtil.ItemCallback<RetrofitDataModel.Result>() {
    override fun areItemsTheSame(oldItem: RetrofitDataModel.Result, newItem: RetrofitDataModel.Result): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RetrofitDataModel.Result, newItem: RetrofitDataModel.Result): Boolean =
        oldItem == newItem

}
) {

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(
            ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class PictureViewHolder(
        private val binding: ImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RetrofitDataModel.Result) = with(binding) {
            ivImage.load(item.urls.regular)
        }
    }

}

