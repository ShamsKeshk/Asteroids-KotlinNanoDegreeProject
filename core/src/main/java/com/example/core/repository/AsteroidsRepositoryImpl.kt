package com.example.core.repository

import com.example.core.data.NearEarth

class AsteroidsRepositoryImpl(private val remoteDataSource: RemoteAsteroidsDataSource,
                              private val localAsteroidsDataSource: LocalAsteroidsDataSource) :
    AsteroidsRepository {

    override suspend fun getAsteroidsData(isForceUpdateData: Boolean): List<NearEarth> {
        val cachedData = localAsteroidsDataSource.getLocalAsteroids()
        if (cachedData.isNotEmpty() && !isForceUpdateData)
            return cachedData

        val remoteDate = remoteDataSource.getRemoteAsteroids()
        localAsteroidsDataSource.deleteCache()
        localAsteroidsDataSource.insertAsteroids(remoteDate.near_earth_objects)
        return localAsteroidsDataSource.getLocalAsteroids()
    }

    override suspend fun getCachedAsteroidsData(): List<NearEarth>{
        return localAsteroidsDataSource.getLocalAsteroids()
    }

    override suspend fun getTodayAsteroidsData(): List<NearEarth>{
        return localAsteroidsDataSource.getTodayAsteroidsData()
    }

    override suspend fun getAsteroidDataById(id: String): NearEarth {
        return localAsteroidsDataSource.getAsteroidDataById(id)
    }

    override suspend fun getPictureOfDay() = remoteDataSource.getPictureOfTheDay()
}