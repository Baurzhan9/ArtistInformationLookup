package com.example.pixabayapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pixabayapp.adapter.AlbumAdapter
import com.example.pixabayapp.loader.AlbumLoader
import com.example.pixabayapp.R
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        var query = intent.getStringExtra("query")
        setupViews()
        loadAlbumInfo(query)
    }

    private fun setupViews() {
        albums_view.layoutManager = LinearLayoutManager(this)
    }

    private fun loadAlbumInfo(albumName: String) {
        AlbumLoader(
            onSuccess = {
                albums_view.adapter =
                    AlbumAdapter(it)

            }
        ).loadAlbums(albumName)
    }



//    private fun showInfo(album_artist: String) {
//        btn_tracks_album.setOnClickListener{
//            loadAlbumInfo(album_artist)
//        }
//
//    }

}


