package com.example.nasaapp.framwork.local.data

import com.example.core.data.Links

data class LinksEntity(val self: String?,
                       val previous: String?,
                       val next: String?) {


    fun asDomain(): Links{
        return Links(self,previous,next)
    }

    companion object{

        fun toEntity(links: Links?): LinksEntity{
            return LinksEntity(links?.self,links?.previous,links?.next)
        }
    }
}