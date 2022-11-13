package com.example.nasaapp.framwork.local.di

import android.content.Context
import com.example.nasaapp.framwork.local.database.AsteroidsDao
import com.example.nasaapp.framwork.local.database.AsteroidsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CachingModule {

    @Provides
    fun provideAsteroidsDatabase(@ApplicationContext context: Context): AsteroidsDatabase{
        return AsteroidsDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideAsteroidsDao(asteroidsDatabase: AsteroidsDatabase): AsteroidsDao{
        return asteroidsDatabase.getAsteroidsDao()
    }
}