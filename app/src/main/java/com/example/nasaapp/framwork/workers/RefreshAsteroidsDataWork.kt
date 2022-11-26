package com.example.nasaapp.framwork.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.core.repository.AsteroidsRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException

@HiltWorker
class RefreshAsteroidsDataWork @AssistedInject constructor(@Assisted appContext: Context,
                                                           @Assisted params: WorkerParameters,
                                                           val asteroidsRepository: AsteroidsRepositoryImpl):
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshAsteroidsDataWork"
    }

    override suspend fun doWork(): Result {
        return try {
            asteroidsRepository.getAsteroidsData(true)
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}