package com.example.nasaapp.framwork.di

import android.content.Context
import com.example.core.repository.AsteroidsRepositoryImpl
import com.example.core.usecases.*
import com.example.nasaapp.domain.asteroidsUseCases.AsteroidsUseCases
import com.example.nasaapp.framwork.local.LocalAsteroidsDataSourceImp
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
                                   localAsteroidsDataSource: LocalAsteroidsDataSourceImp): AsteroidsRepositoryImpl{

        return AsteroidsRepositoryImpl(remoteAsteroidsDataSource,localAsteroidsDataSource)
    }

    @Provides
    @Singleton
    fun provideRefreshAsteroidsDataWork(@ApplicationContext context: Context): RefreshAsteroidsWorkManager {
        return RefreshAsteroidsWorkManager(context)
    }

    @Provides
    @Singleton
    fun provideGetTodayAsteroidsUseCase(asteroidsRepository: AsteroidsRepositoryImpl): GetTodayAsteroidsUseCase {
       return GetTodayAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideGetWeekAsteroidsUseCase(asteroidsRepository: AsteroidsRepositoryImpl): GetWeekAsteroidsUseCase{
        return GetWeekAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideGetCachedAsteroidsUseCase(asteroidsRepository: AsteroidsRepositoryImpl): GetCachedAsteroidsUseCase{
        return GetCachedAsteroidsUseCase(asteroidsRepository)
    }

    @Provides
    @Singleton
    fun provideAsteroidsPictureOfTheDayUseCase(asteroidsRepositoryImpl: AsteroidsRepositoryImpl): GetPictureOfTheDayUseCase{
        return GetPictureOfTheDayUseCase(asteroidsRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideGetAsteroidByIdUseCase(asteroidsRepositoryImpl: AsteroidsRepositoryImpl): GetAsteroidByIdUseCase{
        return GetAsteroidByIdUseCase(asteroidsRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideAsteroidsUseCases(getTodayAsteroidsUseCase: GetTodayAsteroidsUseCase,
                                 getCachedAsteroidsUseCase: GetCachedAsteroidsUseCase,
                                 getWeekAsteroidsUseCase: GetWeekAsteroidsUseCase,
                                 getPictureOfTheDayUseCase: GetPictureOfTheDayUseCase,
                                 getAsteroidByIdUseCase: GetAsteroidByIdUseCase): AsteroidsUseCases {
        return AsteroidsUseCases(getWeekAsteroidsUseCase,getCachedAsteroidsUseCase,getTodayAsteroidsUseCase,getPictureOfTheDayUseCase,getAsteroidByIdUseCase)
    }
}