package com.example.pixabayapp.loader

import com.example.pixabayapp.api.Artist
import com.example.pixabayapp.api.ArtistResponse
import com.example.pixabayapp.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistsLoader(
    private val onSuccess: (List<Artist>) -> Unit
) {
    fun loadArtists(query: String) {

        Api.getImageApi()
            .getAllArtists(query)
            .enqueue(object : Callback<ArtistResponse> {
                override fun onResponse(
                    call: Call<ArtistResponse>,
                    response: Response<ArtistResponse>
                ) {
                    response.body()?.artists?.let {
                        onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<ArtistResponse>, t: Throwable) {
                }
            })

    }
}