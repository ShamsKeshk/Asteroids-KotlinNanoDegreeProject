package com.example.nasaapp.framwork.remote

import com.example.core.data.AsteroidsData
import com.example.core.data.PictureOfDay
import com.example.core.repository.AsteroidsRepository
import com.example.core.repository.LocalAsteroidsDataSource
import com.example.core.repository.RemoteAsteroidsDataSource
import com.example.nasaapp.framwork.extensions.DateExtensions
import com.example.nasaapp.framwork.local.LocalAsteroidsDataSourceImp
import com.example.nasaapp.framwork.local.database.AsteroidsDatabase
import com.example.nasaapp.framwork.remote.services.AsteroidsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class RemoteAsteroidsDataSourceImp @Inject constructor(private val asteroidsService: AsteroidsService): RemoteAsteroidsDataSource {

    override suspend fun getRemoteAsteroids(): AsteroidsData {
        return asteroidsService.getAsteroids(DateExtensions.getTodayDate()).asDomain()
    }

    override suspend fun getPictureOfTheDay(): PictureOfDay {
        return asteroidsService.getImageOfTheDay()
    }
}