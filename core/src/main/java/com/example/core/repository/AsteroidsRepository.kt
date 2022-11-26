package com.example.core.repository

import com.example.core.data.NearEarth
import com.example.core.data.PictureOfDay

interface AsteroidsRepository {

    suspend fun getAsteroidsData(isForceUpdateData: Boolean = false): List<NearEarth>
    suspend fun getCachedAsteroidsData(): List<NearEarth>
    suspend fun getTodayAsteroidsData(): List<NearEarth>
    suspend fun getAsteroidDataById(id: String): NearEarth
    suspend fun getPictureOfDay(): PictureOfDay


}