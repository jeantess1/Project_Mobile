package com.example.mini_projet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.recyclerview.widget.GridLayoutManager


class DisneyCharacterActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.disneyapi.dev/"

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DisneyCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disney_character)
        getAllCharacters()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun showError(message: String) {
        println("Error: $message")
    }
    private fun getAllCharacters() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyApiService::class.java)

        api.getCharacters().enqueue(object : Callback<DisneyApiResponse> {
            override fun onResponse(
                call: Call<DisneyApiResponse>,
                response: Response<DisneyApiResponse>
            ) {
                if (response.isSuccessful) {
                    val characters = response.body()?.data
                    adapter = DisneyCharacterAdapter(characters!!)
                    recyclerView.adapter = adapter
                    for(character in characters!!) {
                        Log.i("DisneyCharacterActivity", "Name: ${character.name}")
                    }
                }
            }

            override fun onFailure(call: Call<DisneyApiResponse>, t: Throwable) {
                Log.i("DisneyCharacterActivity", "Error: ${t.message}")
            }

        })

    }
}