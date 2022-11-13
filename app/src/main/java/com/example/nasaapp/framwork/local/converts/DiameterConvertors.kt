package com.example.nasaapp.framwork.local.converts

import androidx.room.TypeConverter
import com.example.nasaapp.framwork.local.data.EstimatedDiameterDistanceEntity
import com.example.nasaapp.framwork.local.data.EstimatedDiameterEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class DiameterConvertors {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @TypeConverter
    fun fromEstimatedDiameterDistanceToJson(json: String?): EstimatedDiameterDistanceEntity? {
        val jsonAdapter: JsonAdapter<EstimatedDiameterDistanceEntity> = moshi.adapter(EstimatedDiameterDistanceEntity::class.java)
        return if (json.isNullOrEmpty()){
            EstimatedDiameterDistanceEntity(null,null)
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun estimatedDiameterDistanceToJson(estimatedDiameterDistanceEntity: EstimatedDiameterDistanceEntity?): String? {
        val jsonAdapter: JsonAdapter<EstimatedDiameterDistanceEntity> = moshi.adapter(EstimatedDiameterDistanceEntity::class.java)
        return if (estimatedDiameterDistanceEntity == null){
           null
        }else {
            jsonAdapter.toJson(estimatedDiameterDistanceEntity)
        }
    }

    @TypeConverter
    fun fromEstimatedDiameterToJson(json: String?): EstimatedDiameterEntity? {
        val jsonAdapter: JsonAdapter<EstimatedDiameterEntity> = moshi.adapter(EstimatedDiameterEntity::class.java)
        return if (json.isNullOrEmpty()){
            EstimatedDiameterEntity(null,null,null,null)
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun estimatedDiameterToJson(estimatedDiameterEntity: EstimatedDiameterEntity?): String? {
        val jsonAdapter: JsonAdapter<EstimatedDiameterEntity> = moshi.adapter(EstimatedDiameterEntity::class.java)
        return if (estimatedDiameterEntity == null){
            null
        }else {
            jsonAdapter.toJson(estimatedDiameterEntity)
        }
    }
}