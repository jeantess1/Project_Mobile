package com.example.mini_projet

import com.example.mini_projet.DisneyApiResponse
import retrofit2.http.GET
import retrofit2.Call

interface DisneyApiService {
    @GET("character")
    fun getCharacters(): Call<DisneyApiResponse>
}