package com.example.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NearEarth(
    val links: Links?,
    val id: String,
    var date: String? = null,
    val neo_reference_id: String,
    val name: String,
    val nasa_jpl_url: String,
    val absolute_magnitude_h: Float,
    val estimated_diameter: EstimatedDiameter?,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<CloseApproachData>?,
    val is_sentry_object: Boolean
): Parcelable{


    fun getCloseApproachData(): String?{
       return close_approach_data?.get(0)?.closeApproachData
    }

    fun getRelativeVelocity(): Double?{
        return close_approach_data?.get(0)?.relativeVelocity?.kilometersPerSecond?.toDoubleOrNull()
    }

    fun getDistanceFromEarth(): Double?{
        return close_approach_data?.get(0)?.missDistance?.astronomical?.toDoubleOrNull()
    }
}