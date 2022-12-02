package com.example.core.data

data class EstimatedDiameter(val kilometers: EstimatedDiameterDistance?,
                             val meters: EstimatedDiameterDistance?,
                             val miles: EstimatedDiameterDistance?,
                             val feet: EstimatedDiameterDistance?)



data class EstimatedDiameterDistance(val estimated_diameter_min: Double?,
                                     val estimated_diameter_max: Double?)