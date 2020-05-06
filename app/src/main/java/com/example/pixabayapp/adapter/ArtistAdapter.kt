package com.example.pixabayapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabayapp.activity.AlbumActivity
import com.example.pixabayapp.api.Artist
import com.example.pixabayapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*

class ArtistAdapter(
    private val images: List<Artist>
) : RecyclerView.Adapter<ArtistAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindImage(images[position])
    }

    override fun getItemCount() = images.size


    inner class ImageViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        fun bindImage(
            Artist: Artist
        ) {

            Picasso.with(itemView.context)
                .load(Artist.image_thumb)
                .into(view.picture_view)
            view.downloads_view.text = Artist.born_year.toString()
            view.tags_view.text = Artist.name
            view.genre_view.text = Artist.genre
            view.website_view.text = Artist.website
            view.biography_view.text = Artist.biography
            itemView.setOnClickListener {
                var intent = Intent(itemView.context, AlbumActivity::class.java).apply{
                    putExtra("query", Artist.name)
                }
                itemView.context.startActivity(intent)
            }

        }
    }
}