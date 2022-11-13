package com.example.nasaapp.framwork.local.converts

import androidx.room.TypeConverter
import com.example.nasaapp.framwork.local.data.CloseApproachDataEntity
import com.example.nasaapp.framwork.local.data.MissDistanceEntity
import com.example.nasaapp.framwork.local.data.RelativeVelocityEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class CloseApproachConvertors {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    @TypeConverter
    fun fromJsonToMissDistanceEntity(json: String?): MissDistanceEntity? {
        val jsonAdapter: JsonAdapter<MissDistanceEntity> = moshi.adapter(
            MissDistanceEntity::class.java)
        return if (json.isNullOrEmpty()){
            MissDistanceEntity(null,null,null,null)//Code Smell
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun missDistanceEntityToJson(missDistanceEntity: MissDistanceEntity?): String? {
        val jsonAdapter: JsonAdapter<MissDistanceEntity> = moshi.adapter(
            MissDistanceEntity::class.java)
        return if (missDistanceEntity == null){
            null
        }else {
            jsonAdapter.toJson(missDistanceEntity)
        }
    }

    @TypeConverter
    fun fromJsonToRelativeVelocity(json: String?): RelativeVelocityEntity? {
        val jsonAdapter: JsonAdapter<RelativeVelocityEntity> = moshi.adapter(
            RelativeVelocityEntity::class.java)
        return if (json.isNullOrEmpty()){
            RelativeVelocityEntity(null,null,null)
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun relativeVelocityToJson(relativeVelocity: RelativeVelocityEntity?): String? {
        val jsonAdapter: JsonAdapter<RelativeVelocityEntity> = moshi.adapter(
            RelativeVelocityEntity::class.java)
        return if (relativeVelocity == null){
            null
        }else {
            jsonAdapter.toJson(relativeVelocity)
        }
    }

    @TypeConverter
    fun fromJsonToCloseApproachData(json: String?): List<CloseApproachDataEntity>? {
        val type = Types.newParameterizedType(List::class.java, CloseApproachDataEntity::class.java)
        val jsonAdapter = moshi.adapter<List<CloseApproachDataEntity>>(type)

        return if (json.isNullOrEmpty()){
            null
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun closeApproachDataToJson(closeApproachData: List<CloseApproachDataEntity>?): String? {
        val type = Types.newParameterizedType(List::class.java, CloseApproachDataEntity::class.java)
        val jsonAdapter = moshi.adapter<List<CloseApproachDataEntity>>(type)

        return if (closeApproachData == null){
            null
        }else {
            jsonAdapter.toJson(closeApproachData)
        }
    }

}