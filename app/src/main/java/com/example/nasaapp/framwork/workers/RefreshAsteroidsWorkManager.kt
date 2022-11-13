package com.example.nasaapp.framwork.workers

import android.content.Context
import android.os.Build
import androidx.work.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class RefreshAsteroidsWorkManager @Inject constructor(private val applicationContext: Context) {

    fun setupRecurringWork() {
        val repeatingRequest = createRepeatingRequestOfRefreshData(createWorkerConstraints())

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            RefreshAsteroidsDataWork.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest)
    }

    private fun createWorkerConstraints(): Constraints{
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setRequiresDeviceIdle(true)
                }
            }.build()
    }

    private fun createRepeatingRequestOfRefreshData(constraints: Constraints): PeriodicWorkRequest {
        return PeriodicWorkRequestBuilder<RefreshAsteroidsDataWork>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()
    }
}