package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository

class GetCachedAsteroidsUseCase(private val repository: AsteroidsRepository) {

    suspend fun getCachedAsteroidsData() = repository.getCachedAsteroidsData()
}