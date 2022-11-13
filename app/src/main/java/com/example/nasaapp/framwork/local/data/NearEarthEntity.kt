package com.example.nasaapp.framwork.local.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.core.data.NearEarth

//Domain model -> act inside app "NearEarth"
//Entity Model -> act with Room database  "NearEarthEntity"
//Network Model -> act with retrofit network "NetworkNearEarth"

@Entity(tableName = "asteroids")
data class NearEarthEntity(
    @Embedded
    val links: LinksEntity?,
    @PrimaryKey
    val id: String,
    var date: String? = null,
    val neo_reference_id: String,
    val name: String,
    val nasa_jpl_url: String,
    val absolute_magnitude_h: Float,
    @Embedded
    val estimated_diameter: EstimatedDiameterEntity?,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<CloseApproachDataEntity>?,
    val is_sentry_object: Boolean
) {

    fun asDomain(): NearEarth{
        return NearEarth(links = links?.asDomain(),
            id,
            date,
            neo_reference_id,
            name,
            nasa_jpl_url,
            absolute_magnitude_h,
            estimated_diameter = estimated_diameter?.asDomain(),
            is_potentially_hazardous_asteroid,
            close_approach_data = CloseApproachDataEntity.asDomain(close_approach_data),
        is_sentry_object)
    }

    companion object{

        fun toEntity(nearEarth: NearEarth): NearEarthEntity{
            return nearEarth.let {
                NearEarthEntity(LinksEntity.toEntity(it.links),
                    it.id,it.date,
                    it.neo_reference_id,
                    it.name,it.nasa_jpl_url,
                    it.absolute_magnitude_h,
                    EstimatedDiameterEntity.asEntity(it.estimated_diameter),
                    it.is_potentially_hazardous_asteroid,
                    CloseApproachDataEntity.asEntity(it.close_approach_data),
                    it.is_sentry_object)
            }
        }
    }
}