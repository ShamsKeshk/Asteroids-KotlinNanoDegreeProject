package com.example.nasaapp.framwork.local

import com.example.core.data.NearEarth
import com.example.core.repository.LocalAsteroidsDataSource
import com.example.nasaapp.framwork.extensions.DateExtensions
import com.example.nasaapp.framwork.local.data.NearEarthEntity
import com.example.nasaapp.framwork.local.database.AsteroidsDao
import javax.inject.Inject

class LocalAsteroidsDataSourceImp @Inject constructor(val asteroidsDao: AsteroidsDao): LocalAsteroidsDataSource {

    override suspend fun insertAsteroids(listOfNearEarth: List<NearEarth>?) {

        val listOfAsteroids = listOfNearEarth?.map {
            NearEarthEntity.toEntity(it)
        }?.toTypedArray()

        if (listOfAsteroids.isNullOrEmpty()){
            asteroidsDao.deleteCache()
        }else {
            asteroidsDao.insertAll(*listOfAsteroids)
        }

    }

    override suspend fun getLocalAsteroids(): List<NearEarth> {
        return asteroidsDao.getAsteroids(DateExtensions.getTodayDate()).map {
            it.asDomain()
        }
    }

    override suspend fun getTodayAsteroidsData(): List<NearEarth> {
        return asteroidsDao.getTodayAsteroids(DateExtensions.getTodayDate()).map {
            it.asDomain()
        }
    }

    override suspend fun deleteCache() {
        asteroidsDao.deleteCache()
    }
}