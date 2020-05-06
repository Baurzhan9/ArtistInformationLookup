package com.example.pixabayapp.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabayapp.api.Album
import com.example.pixabayapp.R
import com.example.pixabayapp.activity.AlbumActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*

class AlbumAdapter(
    private val album: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bindAlbum(albums = album[position])

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = AlbumViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
    )


    override fun getItemCount() = album.size

    inner class AlbumViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bindAlbum(albums: Album) {

            Picasso.with(itemView.context)
                .load(albums.img_album)
                .into(view.picture_view)
            view.tags_view.text = albums.name_album
            view.downloads_view.text = albums.released_year_album
            view.genre_view.text = albums.genre_album
            view.website_view.text = albums.artist_name_album
            view.biography_view.text = albums.desc_album


            view.setOnClickListener {
//                onAlbumClicked(albums)
                var intent = Intent(itemView.context, AlbumActivity::class.java).apply{
                    putExtra("query", albums.name_album)
                }
                itemView.context.startActivity(intent)
            }
        }

    }
}
