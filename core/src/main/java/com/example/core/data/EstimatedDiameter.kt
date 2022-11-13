package com.example.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EstimatedDiameter(val kilometers: EstimatedDiameterDistance?,
                             val meters: EstimatedDiameterDistance?,
                             val miles: EstimatedDiameterDistance?,
                             val feet: EstimatedDiameterDistance?): Parcelable


@Parcelize
data class EstimatedDiameterDistance(val estimated_diameter_min: Double?,
                                     val estimated_diameter_max: Double?): Parcelable