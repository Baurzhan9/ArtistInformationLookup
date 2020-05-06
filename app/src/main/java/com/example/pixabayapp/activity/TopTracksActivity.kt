package com.example.pixabayapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pixabayapp.R
import com.example.pixabayapp.adapter.TrackAdapter
import com.example.pixabayapp.loader.TracksLoader
import kotlinx.android.synthetic.main.activity_top_tracks.*

class TopTracksActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_tracks)

        setupViews()

    }


    private fun setupViews() {
        tracks_view.layoutManager = LinearLayoutManager(this)

    }

    private fun loadTrackInfo(trackName: String) {
        TracksLoader(
            onSuccess = {
                tracks_view.adapter =
                    TrackAdapter(it)
            }

        ).loadTracks(trackName)
    }

    private fun showInfo(track_artist: String) {
        loadTrackInfo(track_artist)
    }

}
