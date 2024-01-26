package com.ivanur.peperomia.recyclerViewExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivanur.peperomia.R
import com.ivanur.peperomia.recyclerViewExample.adapter.SuperheroAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }
    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvSuperhero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperheroAdapter(SuperheroProvider.superherosList)
    }
}