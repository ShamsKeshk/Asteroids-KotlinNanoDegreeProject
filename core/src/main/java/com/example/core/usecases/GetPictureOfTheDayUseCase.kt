package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository
import com.example.core.repository.AsteroidsRepositoryImpl

class GetPictureOfTheDayUseCase(private val asteroidsRepository: AsteroidsRepository) {

    suspend fun getPictureOfDay() = asteroidsRepository.getPictureOfDay()
}