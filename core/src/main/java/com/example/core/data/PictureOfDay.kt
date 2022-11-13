package com.example.core.data

data class PictureOfDay(val media_type: String? = null, val title: String? = null,
                        val url: String? = null){


    fun shouldLoadImage(): Boolean{
        return media_type?.equals("image",true) == true
    }
}