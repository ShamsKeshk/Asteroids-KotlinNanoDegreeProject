package com.example.nasaapp.framwork.remote.data

import com.example.core.data.CloseApproachData
import com.example.core.data.MissDistance
import com.example.core.data.RelativeVelocity
import com.example.nasaapp.framwork.local.data.CloseApproachDataEntity
import com.example.nasaapp.framwork.local.data.MissDistanceEntity
import com.example.nasaapp.framwork.local.data.RelativeVelocityEntity
import com.squareup.moshi.Json

data class RemoteCloseApproachData(
                        val close_approach_date: String?,
                        val close_approach_date_full: String?,
                        val epoch_date_close_approach: Double?,
                        val relative_velocity: RemoteRelativeVelocity?,
                        val miss_distance: RemoteMissDistance?,
                        val orbiting_body: String?){

    private fun asDomain(): CloseApproachData {
        return CloseApproachData(close_approach_date,
            close_approach_date_full,
            epoch_date_close_approach,
            relativeVelocity = relative_velocity?.asDomain(),
            missDistance = miss_distance?.asDomain(),
            orbiting_body)
    }

    private fun asEntity(): CloseApproachDataEntity{
        return CloseApproachDataEntity(close_approach_date,
            close_approach_date_full,
            epoch_date_close_approach,
                relativeVelocity = relative_velocity?.asEntity(),
                missDistance = miss_distance?.asEntity(),
                orbiting_body)
    }

    companion object{

        fun asEntity(remoteCloseApproachData: List<RemoteCloseApproachData>?): List<CloseApproachDataEntity>?{
            return remoteCloseApproachData?.map {
                it.asEntity()
            }
        }

        fun asDomain(remoteCloseApproachData: List<RemoteCloseApproachData>?): List<CloseApproachData>?{
            return remoteCloseApproachData?.map {
                it.asDomain()
            }
        }
    }
}


data class RemoteRelativeVelocity(val kilometers_per_second:String?,
                       val kilometers_per_hour: String?,
                       val miles_per_hour: String?){

    fun asEntity(): RelativeVelocityEntity{
        return RelativeVelocityEntity(kilometers_per_second,
            kilometers_per_hour,
            miles_per_hour)
    }

    fun asDomain(): RelativeVelocity {
        return RelativeVelocity(kilometers_per_second,
            kilometers_per_hour,
            miles_per_hour)
    }

    companion object{

        fun asEntity(relativeVelocity: RelativeVelocity?): RelativeVelocityEntity{
            return relativeVelocity.let {
                RelativeVelocityEntity(it?.kilometersPerSecond,
                    it?.kilometersPerHour,
                    it?.milesPerHour)
            }
        }
    }
}


data class RemoteMissDistance(val astronomical: String?,
                   val lunar: String?,
                   val kilometers: String?,
                   val miles: String?){


    fun asDomain(): MissDistance {
        return MissDistance(astronomical,
            lunar,
            kilometers,
            miles)
    }

    fun asEntity(): MissDistanceEntity{
          return  MissDistanceEntity(astronomical,
              lunar,
              kilometers,
              miles)
        }

    companion object{

        fun asEntity(missDistance: MissDistance?): MissDistanceEntity{
            return missDistance.let {
                MissDistanceEntity(it?.astronomical,
                    it?.lunar,
                    it?.kilometers,
                    it?.miles)
            }
        }
    }
}