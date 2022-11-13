package com.example.nasaapp.framwork.local.converts

import androidx.room.TypeConverter
import com.example.nasaapp.framwork.local.data.LinksEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class LinksConvertor {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @TypeConverter
    fun fromJsonToLinks(json: String?): LinksEntity? {
        val jsonAdapter: JsonAdapter<LinksEntity> = moshi.adapter(
            LinksEntity::class.java)
        return if (json.isNullOrEmpty()){
            LinksEntity(null,null,null)
        }else {
            jsonAdapter.fromJson(json)
        }
    }

    @TypeConverter
    fun linksToJson(links: LinksEntity?): String? {
        val jsonAdapter: JsonAdapter<LinksEntity> = moshi.adapter(
            LinksEntity::class.java)
        return if (links == null){
            null
        }else {
            jsonAdapter.toJson(links)
        }
    }
}