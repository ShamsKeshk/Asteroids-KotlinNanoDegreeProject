package com.example.nasaapp.framwork.remote.data

import com.example.core.data.EstimatedDiameter
import com.example.core.data.EstimatedDiameterDistance
import com.example.nasaapp.framwork.local.data.EstimatedDiameterDistanceEntity
import com.example.nasaapp.framwork.local.data.EstimatedDiameterEntity

data class RemoteEstimatedDiameter(val kilometers: RemoteEstimatedDiameterDistance?,
                             val meters: RemoteEstimatedDiameterDistance?,
                             val miles: RemoteEstimatedDiameterDistance?,
                             val feet: RemoteEstimatedDiameterDistance?){

    fun asEntity(): EstimatedDiameterEntity{
        return EstimatedDiameterEntity(kilometers = kilometers?.asEntity(),
        meters = meters?.asEntity(),
        miles = miles?.asEntity(),
        feet = feet?.asEntity())
    }

    fun asDomain(): EstimatedDiameter{
        return EstimatedDiameter(kilometers = kilometers?.asDomain(),
            meters = meters?.asDomain(),
            miles = miles?.asDomain(),
            feet = feet?.asDomain())
    }
}


data class RemoteEstimatedDiameterDistance(val estimated_diameter_min: Double?,
                                     val estimated_diameter_max: Double?){

    fun asEntity(): EstimatedDiameterDistanceEntity {
        return EstimatedDiameterDistanceEntity(estimated_diameter_min, estimated_diameter_max)
    }

    fun asDomain(): EstimatedDiameterDistance {
        return EstimatedDiameterDistance(estimated_diameter_min, estimated_diameter_max)
    }
}