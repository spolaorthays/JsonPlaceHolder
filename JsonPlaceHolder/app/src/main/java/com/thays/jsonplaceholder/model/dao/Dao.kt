package com.thays.jsonplaceholder.model.dao

import android.util.Log
import com.thays.jsonplaceholder.model.Photo
import com.thays.jsonplaceholder.network.Retrofit
import com.thays.jsonplaceholder.network.ServiceListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Dao {

    fun getPhotos(listener: ServiceListener): List<Photo> {

        val call: Call<List<Photo>>? = Retrofit.getApi()?.takePhotos()
        call?.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.body() != null) {
                    listener.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                t.message?.let { Log.d("Error request", it) } //listener.onError(t)
            }

        })
        return ArrayList()
    }
}