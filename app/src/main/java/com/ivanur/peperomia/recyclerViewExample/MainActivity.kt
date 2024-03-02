package com.ivanur.peperomia.recyclerViewExample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
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
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvSuperhero.layoutManager = manager
        binding.rvSuperhero.adapter = SuperheroAdapter(
            SuperheroProvider.superherosList
        ) { superhero -> onItemSelected(superhero) }
        binding.rvSuperhero.addItemDecoration(decoration)
    }

    fun onItemSelected(superhero: Superhero) {
        Toast.makeText(this, superhero.superhero, Toast.LENGTH_SHORT).show()
    }
}