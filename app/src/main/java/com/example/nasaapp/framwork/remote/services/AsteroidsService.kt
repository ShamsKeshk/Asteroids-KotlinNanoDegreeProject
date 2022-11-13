package com.example.nasaapp.framwork.remote.services

import com.example.core.data.PictureOfDay
import com.example.nasaapp.framwork.remote.data.RemoteAsteroidsData
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "w1BfaLEMo3Bt4hzbasCM3kVNz1dUulHcc16Cr5pc"

interface AsteroidsService {

    @GET("/neo/rest/v1/feed?")
    suspend fun getAsteroids(
    @Query("startDate") startDate: String,
    @Query("api_key") apiKey :String = API_KEY): RemoteAsteroidsData

    @GET("/planetary/apod?api_key=$API_KEY")
    suspend fun getImageOfTheDay(): PictureOfDay

}