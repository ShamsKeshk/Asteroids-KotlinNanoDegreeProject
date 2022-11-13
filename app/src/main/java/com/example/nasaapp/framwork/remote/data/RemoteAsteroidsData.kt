package com.example.nasaapp.framwork.remote.data

import com.example.core.data.AsteroidsData
import com.example.core.data.NearEarth
import com.example.nasaapp.framwork.local.data.AsteroidsDataEntity
import com.example.nasaapp.framwork.local.data.NearEarthEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteAsteroidsData(val links: RemoteLinks?,
                          val element_count: Int = 0,
                          val near_earth_objects: Map<String,List<RemoteNearEarth>>?) {

    fun asDomain(): AsteroidsData{

        val nearestEarthObjects : List<NearEarth>? = near_earth_objects?.toList()?.flatMap {
            it.second.map { nearObject ->
                nearObject.asDomain(it.first)
            }
        }

        return AsteroidsData(links?.asDomain(),
            element_count,
            near_earth_objects = nearestEarthObjects)
    }
}