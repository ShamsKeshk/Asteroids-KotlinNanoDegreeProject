package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository

class GetPictureOfTheDayUseCase(private val asteroidsRepository: AsteroidsRepository) {

    suspend fun getPictureOfDay() = asteroidsRepository.getPictureOfDay()
}