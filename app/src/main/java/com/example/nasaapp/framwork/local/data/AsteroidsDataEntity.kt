package com.example.nasaapp.framwork.local.data

import androidx.room.Entity
import com.example.core.data.AsteroidsData
import com.example.core.data.NearEarth


class AsteroidsDataEntity(val links: LinksEntity?,
                          val element_count: Int = 0,
                          val near_earth_objects: List<NearEarthEntity>?) {

    fun asDatabaseEntity(): AsteroidsData{
        val newList = near_earth_objects?.map {
            it.asDomain()
        }

        return AsteroidsData(links = links?.asDomain(),
            element_count,
            near_earth_objects = newList)
    }
}