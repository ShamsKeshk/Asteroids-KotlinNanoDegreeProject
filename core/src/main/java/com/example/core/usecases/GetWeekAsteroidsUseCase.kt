package com.example.core.usecases

import com.example.core.repository.AsteroidsRepositoryImpl

class GetWeekAsteroidsUseCase(private val repository: AsteroidsRepositoryImpl) {

    suspend fun getWeekAsteroids(isForceLoad: Boolean = false) = repository.getAsteroidsData(isForceLoad)
}