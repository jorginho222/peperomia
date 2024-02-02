package com.ivanur.peperomia.apiExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanur.peperomia.databinding.ActivityApiExampleBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApiExampleBinding
    private lateinit var adapter: FamilyAdapter
    private val familiesList = mutableListOf<FamilyItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        searchFamilies()
    }

    private fun initRecyclerView() {
        adapter = FamilyAdapter(familiesList)
        binding.rvFamilies.layoutManager = LinearLayoutManager(this)
        binding.rvFamilies.adapter = adapter
    }

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(Interceptor())
    }.build()

    private fun getRetrofit(): Retrofit {
        val port = ""
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:${port}/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchFamilies() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getFamilies("family")
            val familiesResponse = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val families = familiesResponse?.data ?: emptyList()
                    familiesList.clear()
                    familiesList.addAll(families)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}