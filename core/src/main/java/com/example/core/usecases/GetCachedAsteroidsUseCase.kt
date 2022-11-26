package com.example.core.usecases

import com.example.core.repository.AsteroidsRepositoryImpl

class GetCachedAsteroidsUseCase(private val repository: AsteroidsRepositoryImpl) {

    suspend fun getCachedAsteroidsData() = repository.getCachedAsteroidsData()
}