package com.example.retrofitusingnetworking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    var BASE_URI = "https://appkiduniya.in/wallpaper/Api/User/"

    fun getInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URI)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

}