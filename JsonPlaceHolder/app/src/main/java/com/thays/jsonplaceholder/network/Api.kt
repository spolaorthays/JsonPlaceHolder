package com.thays.jsonplaceholder.network

import com.thays.jsonplaceholder.model.Photo
import com.thays.jsonplaceholder.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/photos")
    fun takePhotos(): Call<List<Photo>>

}