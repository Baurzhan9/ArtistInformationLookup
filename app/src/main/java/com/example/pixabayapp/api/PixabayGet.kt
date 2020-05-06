package com.example.pixabayapp.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayGet {

//    @GET("?key=3588873-8bb0e70fdfcef7f31eee25461")
//    fun getImagesByQuery(
//        @Query("q") query: String
//    ): Call<model>

    @GET("api/v1/json/1/search.php")
    fun getAllArtists(@Query("s") name: String): Call<ArtistResponse>

    @GET("api/v1/json/1/track-top10.php")
    fun getAllTracks(@Query("s") artist_name: String): Call<TrackResponse>

    @GET("api/v1/json/1/searchalbum.php")
    fun getAllAlbums(@Query("s") artist_name_album: String): Call<AlbumResponse>

    @GET("api/v1/json/1/track.php")
    fun getAllAlbumTracks(@Query("s") album_id_track: Int):Call<AlbumTrackResponse>

}
