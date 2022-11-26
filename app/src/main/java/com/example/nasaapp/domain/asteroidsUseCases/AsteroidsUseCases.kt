package com.example.nasaapp.domain.asteroidsUseCases

import com.example.core.usecases.*
import javax.inject.Inject

class AsteroidsUseCases @Inject constructor(
    val getWeekAsteroids: GetWeekAsteroidsUseCase,
    val getCachedAsteroidsData: GetCachedAsteroidsUseCase,
    val getTodayAsteroidsData: GetTodayAsteroidsUseCase,
    val  getPictureOfTheDayUseCase: GetPictureOfTheDayUseCase,
    val getAsteroidByIdUseCase: GetAsteroidByIdUseCase)         {
}