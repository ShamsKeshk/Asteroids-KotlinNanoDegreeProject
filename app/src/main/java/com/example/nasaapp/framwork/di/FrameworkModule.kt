package com.example.nasaapp.framwork.di

import android.content.Context
import com.example.core.repository.AsteroidsRepository
import com.example.core.repository.LocalAsteroidsDataSource
import com.example.core.repository.RemoteAsteroidsDataSource
import com.example.core.usecases.GetCachedAsteroidsUseCase
import com.example.core.usecases.GetPictureOfTheDayUseCase
import com.example.core.usecases.GetTodayAsteroidsUseCase
import com.example.core.usecases.GetWeekAsteroidsUseCase
import com.example.nasaapp.domain.asteroidsUseCases.AsteroidsUseCases
import com.example.nasaapp.framwork.local.LocalAsteroidsDataSourceImp
import com.example.nasaapp.framwork.local.database.AsteroidsDao
import com.example.nasaapp.framwork.remote.RemoteAsteroidsDataSourceImp
import com.example.nasaapp.framwork.workers.RefreshAsteroidsWorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    fun provideAsteroidsRepository(remoteAsteroidsDataSource: RemoteAsteroidsDataSourceImp,
                                   localAsteroidsDataSource: LocalAsteroidsDataSourceImp): AsteroidsRepository{

        return AsteroidsRepository(remoteAsteroidsDataSource,localAsteroidsDataSource)
    }

    @Provides
    @Singleton
    fun provideRefreshAsteroidsDataWork(@ApplicationContext context: Context): RefreshAsteroidsWorkManager {
        return RefreshAsteroidsWorkManager(context)
    }

    @Provides
    @Singleton
    fun provideGetTodayAsteroidsUseCase(asteroidsRepository: AsteroidsRepository): GetTodayAsteroidsUseCase {
       return GetTodayAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideGetWeekAsteroidsUseCase(asteroidsRepository: AsteroidsRepository): GetWeekAsteroidsUseCase{
        return GetWeekAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideGetCachedAsteroidsUseCase(asteroidsRepository: AsteroidsRepository): GetCachedAsteroidsUseCase{
        return GetCachedAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideAsteroidsPictureOfTheDayUseCase(asteroidsRepository: AsteroidsRepository): GetPictureOfTheDayUseCase{
        return GetPictureOfTheDayUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideAsteroidsUseCases(getTodayAsteroidsUseCase: GetTodayAsteroidsUseCase,
                                 getCachedAsteroidsUseCase: GetCachedAsteroidsUseCase,
                                 getWeekAsteroidsUseCase: GetWeekAsteroidsUseCase,
                                 getPictureOfTheDayUseCase: GetPictureOfTheDayUseCase): AsteroidsUseCases {
        return AsteroidsUseCases(getWeekAsteroidsUseCase,getCachedAsteroidsUseCase,getTodayAsteroidsUseCase,getPictureOfTheDayUseCase)
    }
}