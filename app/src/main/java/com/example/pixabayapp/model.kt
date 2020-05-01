package com.example.pixabayapp

import android.widget.ImageView
import com.squareup.picasso.Picasso

data class model(
    val hits: List<result>
)

data class result(
    val largeImageURL: String,
    val tags: String,
    val likes: Int
)
fun ImageView.loadFromUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}