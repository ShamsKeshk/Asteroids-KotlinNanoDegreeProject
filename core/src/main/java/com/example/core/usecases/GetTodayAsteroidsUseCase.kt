package com.example.core.usecases

import com.example.core.repository.AsteroidsRepository

class GetTodayAsteroidsUseCase(private val repository: AsteroidsRepository) {

    suspend fun getTodayAsteroidsData() = repository.getTodayAsteroidsData()
}