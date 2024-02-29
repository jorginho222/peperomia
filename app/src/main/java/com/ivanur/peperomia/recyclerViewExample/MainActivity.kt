package com.ivanur.peperomia.recyclerViewExample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanur.peperomia.databinding.ActivityMainBinding
import com.ivanur.peperomia.recyclerViewExample.adapter.SuperheroAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = SuperheroAdapter(
            SuperheroProvider.superherosList
        ) { superhero -> onItemSelected(superhero) }
    }

    fun onItemSelected(superhero: Superhero) {
        Toast.makeText(this, superhero.superhero, Toast.LENGTH_SHORT).show()
    }
}