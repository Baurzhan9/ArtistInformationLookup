package com.example.pixabayapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private const val ENDPOINT = "https://theaudiodb.com/"

    val retrofit =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getImageApi() = retrofit.create(
        PixabayGet::class.java)
}