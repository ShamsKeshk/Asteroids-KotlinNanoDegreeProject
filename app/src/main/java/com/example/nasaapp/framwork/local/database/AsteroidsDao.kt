package com.example.nasaapp.framwork.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nasaapp.framwork.local.data.NearEarthEntity

@Dao
interface AsteroidsDao {

    @Query("SELECT * FROM asteroids WHERE id = :asteroidId")
    suspend fun getAsteroidById(asteroidId: String): NearEarthEntity

    @Query("DELETE from asteroids")
    suspend fun deleteCache()

    @Query("select * from asteroids order by date DESC")
    fun getAsteroids(): List<NearEarthEntity>

    @Query("select * from asteroids where date >= :date order by date DESC")
    fun getAsteroids(date: String): List<NearEarthEntity>

    @Query("select * from asteroids where date == :date order by date DESC")
    fun getTodayAsteroids(date: String): List<NearEarthEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg nearEarthEntity: NearEarthEntity)
}