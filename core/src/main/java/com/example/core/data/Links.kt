package com.example.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(val self: String?,
                 val previous: String?,
                 val next: String?) : Parcelable{

}