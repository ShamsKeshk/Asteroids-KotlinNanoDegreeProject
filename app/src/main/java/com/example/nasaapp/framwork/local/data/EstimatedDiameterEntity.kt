package com.example.nasaapp.framwork.local.data

import com.example.core.data.EstimatedDiameter
import com.example.core.data.EstimatedDiameterDistance

data class EstimatedDiameterEntity(val kilometers: EstimatedDiameterDistanceEntity?,
                             val meters: EstimatedDiameterDistanceEntity?,
                             val miles: EstimatedDiameterDistanceEntity?,
                             val feet: EstimatedDiameterDistanceEntity?){

    fun asDomain(): EstimatedDiameter {
        return EstimatedDiameter(kilometers = kilometers?.asDomain(),
        meters = meters?.asDomain(),
        miles = miles?.asDomain(),
        feet = feet?.asDomain())
    }

    companion object{

        fun asEntity(estimatedDiameter: EstimatedDiameter?): EstimatedDiameterEntity{
            return estimatedDiameter.let {
                EstimatedDiameterEntity(
                    EstimatedDiameterDistanceEntity.asEntity(it?.kilometers),
                    EstimatedDiameterDistanceEntity.asEntity(it?.meters),
                    EstimatedDiameterDistanceEntity.asEntity(it?.miles),
                    EstimatedDiameterDistanceEntity.asEntity(it?.feet)
                )
            }
        }
    }
}


data class EstimatedDiameterDistanceEntity(val estimated_diameter_min: Double?,
                                     val estimated_diameter_max: Double?){

    fun asDomain(): EstimatedDiameterDistance{
        return EstimatedDiameterDistance(estimated_diameter_min,estimated_diameter_max)
    }

    companion object{

        fun asEntity(estimatedDiameterDistance: EstimatedDiameterDistance?): EstimatedDiameterDistanceEntity{
            return estimatedDiameterDistance.let {
                EstimatedDiameterDistanceEntity(it?.estimated_diameter_min,it?.estimated_diameter_max)
            }
        }
    }
}