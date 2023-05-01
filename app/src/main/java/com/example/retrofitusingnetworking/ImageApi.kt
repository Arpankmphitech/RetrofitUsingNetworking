package com.example.retrofitusingnetworking

import retrofit2.http.GET

interface ImageApi {

    @GET("getwallpaper")
    suspend fun getWallPaper() : Response<ImageItem>

}