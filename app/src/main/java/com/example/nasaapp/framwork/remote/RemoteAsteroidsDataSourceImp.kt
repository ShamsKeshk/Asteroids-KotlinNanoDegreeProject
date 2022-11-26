package com.example.nasaapp.framwork.remote

import com.example.core.data.AsteroidsData
import com.example.core.data.PictureOfDay
import com.example.core.repository.RemoteAsteroidsDataSource
import com.example.nasaapp.framwork.extensions.DateExtensions
import com.example.nasaapp.framwork.remote.services.AsteroidsService
import javax.inject.Inject

class RemoteAsteroidsDataSourceImp @Inject constructor(private val asteroidsService: AsteroidsService): RemoteAsteroidsDataSource {

    override suspend fun getRemoteAsteroids(): AsteroidsData {
        return asteroidsService.getAsteroids(DateExtensions.getTodayDate()).asDomain()
    }

    override suspend fun getPictureOfTheDay(): PictureOfDay {
        return asteroidsService.getImageOfTheDay()
    }
}