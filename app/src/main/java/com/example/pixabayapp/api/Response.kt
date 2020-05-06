package com.example.pixabayapp.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(
    @SerializedName("strArtist") val name: String,
    @SerializedName("intBornYear") val born_year: Int,
    @SerializedName("strGenre") val genre: String,
    @SerializedName("strWebsite") val website: String,
    @SerializedName("strBiographyEN") val biography: String,
    @SerializedName("strArtistThumb") val image_thumb: String,
    @SerializedName("strArtistLogo") val image_logo: String
) : Parcelable

data class ArtistResponse(
    val artists: List<Artist>
)

data class Track(
    @SerializedName("strTrackThumb") val image_track: String,
    @SerializedName("strTrack") val name_track: String,
    @SerializedName("strAlbum") val album_track: String,
    @SerializedName("intDuration") val duration_track: Int,
    @SerializedName("strGenre") val genre_track: String,
    @SerializedName("strMood") val mood_track: String,
    @SerializedName("strArtist") val artist_name: String

)

data class TrackResponse(
    val track: List<Track>
)

@Parcelize
data class Album(

    @SerializedName("idAlbum") val id_album: Int,
    @SerializedName("strAlbum") val name_album: String,
    @SerializedName("intYearReleased") val released_year_album: String,
    @SerializedName("strGenre") val genre_album: String,
    @SerializedName("strArtist") val artist_name_album: String,
    @SerializedName("strAlbumThumb") val img_album: String,
    @SerializedName("strDescriptionEN") val desc_album: String
) : Parcelable

data class AlbumResponse(
    val album: List<Album>
)

data class AlbumTrack(

    @SerializedName("idArtist") val id_artist_track: Int,
    @SerializedName("strTrack") val name_a_track: String,
    @SerializedName("intDuration") val duration_a_track: Int
)

data class AlbumTrackResponse(
    val album_track: List<AlbumTrack>
)




