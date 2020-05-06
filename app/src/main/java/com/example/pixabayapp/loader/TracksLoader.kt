package com.example.pixabayapp.loader

import com.example.pixabayapp.api.Api
import com.example.pixabayapp.api.Track
import com.example.pixabayapp.api.TrackResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TracksLoader (
    private val onSuccess: (List<Track>) -> Unit
) {
    fun loadTracks(trackName: String) {

        Api.getImageApi()
            .getAllTracks(trackName)
            .enqueue(object : Callback<TrackResponse> {
                override fun onResponse(
                    call: Call<TrackResponse>,
                    response: Response<TrackResponse>
                ) {
                    response.body()?.track?.let {
                        onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                }
            })

    }
}