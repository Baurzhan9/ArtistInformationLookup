package com.example.pixabayapp.loader

import com.example.pixabayapp.api.Album
import com.example.pixabayapp.api.AlbumResponse
import com.example.pixabayapp.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumLoader (
    private val onSuccess: (List<Album>) -> Unit

) {
    fun loadAlbums(albumName: String) {

        Api.getImageApi()
            .getAllAlbums(albumName)
            .enqueue(object : Callback<AlbumResponse> {
                override fun onResponse(
                    call: Call<AlbumResponse>,
                    response: Response<AlbumResponse>
                ) {
                    response.body()?.album?.let {
                        onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<AlbumResponse>, t: Throwable) {
                }
            })

    }
}