package com.example.pixabayapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_item.view.*

class Adapter(
    private val images: List<result>
) : RecyclerView.Adapter<Adapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindImage(images[position])
//        holder.itemView.setOnClickListener {
//            val deviceWidht = DisplayMetrics().widthPixels / 3
//            val deviceHeight = DisplayMetrics().heightPixels / 4
//            holder.itemView.layoutParams.width = deviceWidht
//            holder.itemView.layoutParams.height = deviceHeight
//
//        }
    }

    override fun getItemCount() = images.size


    inner class ImageViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        fun bindImage(
            image: result
        ) {
            view.picture_view.loadFromUrl(image.largeImageURL)

            view.downloads_view.text =
                view.context.getString(R.string.likes_fmt, image.likes)
            view.tags_view.text =
                view.context.getString(R.string.tags_fmt, image.tags)
        }
    }
}