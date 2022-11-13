package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository

class GetWeekAsteroidsUseCase(private val repository: AsteroidsRepository) {

    suspend fun getWeekAsteroids(isForceLoad: Boolean = false) = repository.getAsteroidsData(isForceLoad)
}