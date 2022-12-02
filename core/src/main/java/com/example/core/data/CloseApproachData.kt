package com.example.core.data

data class CloseApproachData(val closeApproachData: String?,
                        val closeApproachDateFull: String?,
                        val epochDateCloseApproach: Double?,
                        val relativeVelocity: RelativeVelocity?,
                        val missDistance: MissDistance?,
                        val orbiting_body: String?)



data class RelativeVelocity(val kilometersPerSecond:String?,
                       val kilometersPerHour: String?,
                       val milesPerHour: String?)



data class MissDistance(val astronomical: String?,
                   val lunar: String?,
                   val kilometers: String?,
                   val miles: String?)