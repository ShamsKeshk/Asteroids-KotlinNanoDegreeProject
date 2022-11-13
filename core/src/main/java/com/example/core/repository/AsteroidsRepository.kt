package com.example.core.repository

import com.example.core.data.NearEarth

class AsteroidsRepository(private val remoteDataSource: RemoteAsteroidsDataSource,
                          private val localAsteroidsDataSource: LocalAsteroidsDataSource) {

    suspend fun getAsteroidsData(isForceUpdateData: Boolean = false): List<NearEarth> {
        val cachedData = localAsteroidsDataSource.getLocalAsteroids()
        if (cachedData.isNotEmpty() && !isForceUpdateData)
            return cachedData

        val remoteDate = remoteDataSource.getRemoteAsteroids()
        localAsteroidsDataSource.deleteCache()
        localAsteroidsDataSource.insertAsteroids(remoteDate.near_earth_objects)
        return localAsteroidsDataSource.getLocalAsteroids()
    }

    suspend fun getCachedAsteroidsData(): List<NearEarth>{
        return localAsteroidsDataSource.getLocalAsteroids()
    }

    suspend fun getTodayAsteroidsData(): List<NearEarth>{
        return localAsteroidsDataSource.getTodayAsteroidsData()
    }

    suspend fun getPictureOfDay() = remoteDataSource.getPictureOfTheDay()
}