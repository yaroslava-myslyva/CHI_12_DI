package com.example.chi_12_di.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.chi_12_di.databinding.ItemPhotoBinding
import com.example.chi_12_di.domain.entities.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() { // needs context
    private lateinit var photos: List<Photo>

    fun setList(list: List<Photo>) {
        this.photos = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.photographer.text = photo.photographer
            binding.photographer.setBackgroundColor(Color.parseColor(photo.avgColor))

            Glide.with(itemView)
                .load(photo.smallPhotoUrl)
                .transition(DrawableTransitionOptions.withCrossFade(1500))
                .into(binding.photo)
        }
    }
}
