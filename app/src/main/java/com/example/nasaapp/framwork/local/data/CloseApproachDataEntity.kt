package com.example.nasaapp.framwork.local.data

import com.example.core.data.CloseApproachData
import com.example.core.data.MissDistance
import com.example.core.data.RelativeVelocity
import com.example.nasaapp.framwork.remote.data.RemoteCloseApproachData

data class CloseApproachDataEntity(val closeApproachData: String?,
                        val closeApproachDateFull: String?,
                        val epochDateCloseApproach: Double?,
                        val relativeVelocity: RelativeVelocityEntity?,
                        val missDistance: MissDistanceEntity?,
                        val orbiting_body: String?){

    fun asDomain(): CloseApproachData{
        return CloseApproachData(closeApproachData,
        closeApproachDateFull,
        epochDateCloseApproach,
        relativeVelocity = relativeVelocity?.asDomain(),
        missDistance = missDistance?.asDomain(),
        orbiting_body)
    }

    companion object{

        private fun asEntity(closeApproachData: CloseApproachData?): CloseApproachDataEntity{
            return closeApproachData.let {
                CloseApproachDataEntity(it?.closeApproachData,
                    it?.closeApproachDateFull,
                    it?.epochDateCloseApproach,
                    RelativeVelocityEntity.asEntity(it?.relativeVelocity),
                    MissDistanceEntity.asEntity(it?.missDistance),
                    it?.orbiting_body
                )
            }
        }

        fun asEntity(closeApproachData: List<CloseApproachData>?): List<CloseApproachDataEntity>?{
            return closeApproachData?.map {
                asEntity(it)
            }
        }

        fun asDomain(closeApproachDataEntity: List<CloseApproachDataEntity>?): List<CloseApproachData>?{
            return closeApproachDataEntity?.map {
                it.asDomain()
            }
        }
    }
}


data class RelativeVelocityEntity(val kilometersPerSecond:String?,
                       val kilometersPerHour: String?,
                       val milesPerHour: String?){

    fun asDomain(): RelativeVelocity{
        return RelativeVelocity(kilometersPerSecond,
        kilometersPerHour,
        milesPerHour)
    }

    companion object{

        fun asEntity(relativeVelocity: RelativeVelocity?): RelativeVelocityEntity{
            return relativeVelocity.let {
                RelativeVelocityEntity(it?.kilometersPerSecond,it?.kilometersPerHour,it?.milesPerHour)
            }
        }
    }
}


data class MissDistanceEntity(val astronomical: String?,
                   val lunar: String?,
                   val kilometers: String?,
                   val miles: String?){

    fun asDomain(): MissDistance{
        return MissDistance(astronomical,
        lunar,
        kilometers,
        miles)
    }

    companion object{

        fun asEntity(missDistance: MissDistance?): MissDistanceEntity{
            return missDistance.let {
                MissDistanceEntity(it?.astronomical,it?.lunar,it?.kilometers,it?.miles)
            }
        }
    }
}