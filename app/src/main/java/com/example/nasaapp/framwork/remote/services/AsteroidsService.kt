package com.example.nasaapp.framwork.remote.services

import com.example.core.data.PictureOfDay
import com.example.nasaapp.BuildConfig
import com.example.nasaapp.framwork.remote.data.RemoteAsteroidsData
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = BuildConfig.ASTEROIDS_API_KEY

interface AsteroidsService {

    @GET("/neo/rest/v1/feed?")
    suspend fun getAsteroids(
    @Query("startDate") startDate: String,
    @Query("api_key") apiKey :String = API_KEY): RemoteAsteroidsData

    @GET("/planetary/apod?api_key=$API_KEY")
    suspend fun getImageOfTheDay(): PictureOfDay

}