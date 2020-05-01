package com.example.pixabayapp


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayGet {

    @GET("?key=3588873-8bb0e70fdfcef7f31eee25461")
    fun getImagesByQuery(
        @Query("q") query: String
    ): Call<model>
}
