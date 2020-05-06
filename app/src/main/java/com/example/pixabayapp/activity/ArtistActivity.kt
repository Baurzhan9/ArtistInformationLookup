package com.example.pixabayapp.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pixabayapp.R
import com.example.pixabayapp.adapter.ArtistAdapter
import com.example.pixabayapp.loader.ArtistsLoader
import kotlinx.android.synthetic.main.activity_main.*

class ArtistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        images_list.layoutManager = GridLayoutManager(this, 1)

        query_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                loadArtists(s.toString())
            }
        })
    }

    private fun loadArtists(query: String) {
        ArtistsLoader(onSuccess = {
            images_list.adapter = ArtistAdapter(it)
        }).loadArtists(query)
    }
}
