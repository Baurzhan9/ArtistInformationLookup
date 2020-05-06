package com.example.pixabayapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabayapp.R
import com.example.pixabayapp.api.Track
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*

class TrackAdapter(
    private val track: List<Track>
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) =
        holder.bindTrack(tracks = track[position])

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TrackViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
    )


    override fun getItemCount() = track.size

    inner class TrackViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bindTrack(tracks: Track) {
            Picasso.with(itemView.context)
                .load(tracks.image_track)
                .into(view.picture_view)

            view.tags_view.text = tracks.name_track
            view.downloads_view.text = tracks.album_track
            view.genre_view.text = tracks.duration_track.toString()
            view.website_view.text = tracks.genre_track
            view.biography_view.text = tracks.mood_track

        }

    }
}
