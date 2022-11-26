package com.example.core.repository

import com.example.core.data.NearEarth

interface LocalAsteroidsDataSource {

    suspend fun insertAsteroids(listOfNearEarth: List<NearEarth>?)

    suspend fun getLocalAsteroids(): List<NearEarth>

    suspend fun getTodayAsteroidsData(): List<NearEarth>

    suspend fun deleteCache()

    suspend fun getAsteroidDataById(id: String): NearEarth
}