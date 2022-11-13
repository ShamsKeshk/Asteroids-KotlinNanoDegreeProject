package com.example.nasaapp.framwork.remote.data

import com.example.core.data.Links
import com.example.nasaapp.framwork.local.data.LinksEntity

data class RemoteLinks(val self: String?,
                       val previous: String?,
                       val next: String?) {

    fun asEntity(): LinksEntity{
        return LinksEntity(self,previous,next)
    }

    fun asDomain(): Links{
        return Links(self,previous,next)
    }

}