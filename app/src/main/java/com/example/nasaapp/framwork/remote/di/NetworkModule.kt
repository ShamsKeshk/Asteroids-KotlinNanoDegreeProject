package com.example.nasaapp.framwork.remote.di

import com.example.nasaapp.framwork.remote.services.AsteroidsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val KEY_BASE_NASA_URL = "https://api.nasa.gov"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideMoshiBuilder(): Moshi{
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(KEY_BASE_NASA_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    @Singleton
    @Provides
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun provideAsteroidsService(retrofit: Retrofit): AsteroidsService {
        return retrofit.create(AsteroidsService::class.java)
    }

}