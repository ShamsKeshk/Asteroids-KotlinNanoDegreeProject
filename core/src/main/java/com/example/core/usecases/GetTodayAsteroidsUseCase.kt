package com.example.core.usecases

import com.example.core.repository.AsteroidsRepositoryImpl

class GetTodayAsteroidsUseCase(private val repository: AsteroidsRepositoryImpl) {

    suspend fun getTodayAsteroidsData() = repository.getTodayAsteroidsData()
}