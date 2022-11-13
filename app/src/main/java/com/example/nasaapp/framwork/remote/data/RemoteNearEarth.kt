package com.example.nasaapp.framwork.remote.data

import com.example.core.data.NearEarth
import com.example.nasaapp.framwork.local.data.CloseApproachDataEntity
import com.example.nasaapp.framwork.local.data.NearEarthEntity

data class RemoteNearEarth(
    val links: RemoteLinks?,
    val id: String,
    val neo_reference_id: String,
    val name: String,
    val nasa_jpl_url: String,
    val absolute_magnitude_h: Float,
    val estimated_diameter: RemoteEstimatedDiameter?,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<RemoteCloseApproachData>?,
    val is_sentry_object: Boolean
) {

    fun asEntity(date: String? = null): NearEarthEntity{
        return NearEarthEntity(links = links?.asEntity(),
            id,
            date = date,
            neo_reference_id,
            name,
            nasa_jpl_url,
            absolute_magnitude_h,
            estimated_diameter = estimated_diameter?.asEntity(),
            is_potentially_hazardous_asteroid,
            close_approach_data = RemoteCloseApproachData.asEntity(close_approach_data),
            is_sentry_object)
    }

    fun asDomain(date: String? = null): NearEarth{
        return NearEarth(links = links?.asDomain(),
            id,
            date = date,
            neo_reference_id,
            name,
            nasa_jpl_url,
            absolute_magnitude_h,
            estimated_diameter = estimated_diameter?.asDomain(),
            is_potentially_hazardous_asteroid,
            close_approach_data = RemoteCloseApproachData.asDomain(close_approach_data),
            is_sentry_object)
    }
}