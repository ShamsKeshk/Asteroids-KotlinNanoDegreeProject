package com.example.nasaapp.domain.asteroidsUseCases

import com.example.core.usecases.GetCachedAsteroidsUseCase
import com.example.core.usecases.GetPictureOfTheDayUseCase
import com.example.core.usecases.GetTodayAsteroidsUseCase
import com.example.core.usecases.GetWeekAsteroidsUseCase
import javax.inject.Inject

class AsteroidsUseCases @Inject constructor(
    val getWeekAsteroids: GetWeekAsteroidsUseCase,
    val getCachedAsteroidsData: GetCachedAsteroidsUseCase,
    val getTodayAsteroidsData: GetTodayAsteroidsUseCase,
    val  getPictureOfTheDayUseCase: GetPictureOfTheDayUseCase)         {
}