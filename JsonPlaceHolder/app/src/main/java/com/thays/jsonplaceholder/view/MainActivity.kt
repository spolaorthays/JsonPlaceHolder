package com.thays.jsonplaceholder.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thays.jsonplaceholder.R
import com.thays.jsonplaceholder.controller.RecyclerPhotosAdapter
import com.thays.jsonplaceholder.model.Photo
import com.thays.jsonplaceholder.model.dao.Dao
import com.thays.jsonplaceholder.network.ServiceListener

class MainActivity : AppCompatActivity(), ServiceListener {

    private lateinit var recyclerView: RecyclerView
    private var recyclerPhotosAdapter: RecyclerPhotosAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
    }

    fun setupRecycler() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = Dao()
        recyclerPhotosAdapter = RecyclerPhotosAdapter(dao.getPhotos(this))
        recyclerView.adapter = recyclerPhotosAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onSuccess(`object`: Any?) {
        val photos = `object` as List<Photo>
        recyclerPhotosAdapter?.updatePhotos(photos)

    }

    override fun onError(throwable: Throwable?) {
        //Nothing
    }
}
