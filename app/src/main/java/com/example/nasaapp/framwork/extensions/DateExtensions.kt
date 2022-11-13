package com.example.nasaapp.framwork.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateExtensions {

    companion object{
        fun getTodayDate(): String{
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            return current.format(formatter)
        }
    }

}