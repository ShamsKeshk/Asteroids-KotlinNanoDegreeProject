package com.example.core.repository

import com.example.core.data.AsteroidsData
import com.example.core.data.PictureOfDay

interface RemoteAsteroidsDataSource {

    suspend fun getRemoteAsteroids(): AsteroidsData

    suspend fun getPictureOfTheDay(): PictureOfDay

}