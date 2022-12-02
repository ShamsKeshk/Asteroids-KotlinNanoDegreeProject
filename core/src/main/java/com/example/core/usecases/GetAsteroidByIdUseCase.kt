package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository
import com.example.core.repository.AsteroidsRepositoryImpl

class GetAsteroidByIdUseCase(private val repository: AsteroidsRepository) {

    suspend fun getCachedAsteroidsData(id: String) = repository.getAsteroidDataById(id)
}