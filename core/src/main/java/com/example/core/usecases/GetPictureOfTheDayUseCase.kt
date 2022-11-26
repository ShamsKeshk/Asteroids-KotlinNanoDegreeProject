package com.example.core.usecases

import com.example.core.repository.AsteroidsRepositoryImpl

class GetPictureOfTheDayUseCase(private val asteroidsRepository: AsteroidsRepositoryImpl) {

    suspend fun getPictureOfDay() = asteroidsRepository.getPictureOfDay()
}