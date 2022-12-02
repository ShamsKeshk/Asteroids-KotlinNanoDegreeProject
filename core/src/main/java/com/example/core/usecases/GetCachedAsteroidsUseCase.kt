package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository
import com.example.core.repository.AsteroidsRepositoryImpl

class GetCachedAsteroidsUseCase(private val repository: AsteroidsRepository) {

    suspend fun getCachedAsteroidsData() = repository.getCachedAsteroidsData()
}