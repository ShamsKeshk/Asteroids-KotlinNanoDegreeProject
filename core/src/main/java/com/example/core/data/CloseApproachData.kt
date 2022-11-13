package com.example.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CloseApproachData(val closeApproachData: String?,
                        val closeApproachDateFull: String?,
                        val epochDateCloseApproach: Double?,
                        val relativeVelocity: RelativeVelocity?,
                        val missDistance: MissDistance?,
                        val orbiting_body: String?): Parcelable


@Parcelize
data class RelativeVelocity(val kilometersPerSecond:String?,
                       val kilometersPerHour: String?,
                       val milesPerHour: String?): Parcelable


@Parcelize
data class MissDistance(val astronomical: String?,
                   val lunar: String?,
                   val kilometers: String?,
                   val miles: String?): Parcelable