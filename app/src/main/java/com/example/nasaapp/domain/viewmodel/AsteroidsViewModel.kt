package com.example.nasaapp.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.NearEarth
import com.example.core.data.PictureOfDay
import com.example.nasaapp.domain.asteroidsUseCases.AsteroidsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.nasaapp.framwork.model.Result
import com.example.nasaapp.framwork.interfaces.RetryCallback
import com.example.nasaapp.framwork.workers.RefreshAsteroidsWorkManager
import kotlinx.coroutines.*


@HiltViewModel
class AsteroidsViewModel @Inject constructor(
    private val asteroidsUseCases: AsteroidsUseCases,
    refreshAsteroidsWorkManager: RefreshAsteroidsWorkManager): ViewModel() {

    private val listOfNearestEarthObjects = MutableLiveData<Result<List<NearEarth>>>()

    private val selectedNearestEarthObject = MutableLiveData<Result<NearEarth>>()

    fun asteroidsLiveDate(): LiveData<Result<List<NearEarth>>>{
       return listOfNearestEarthObjects
    }

    private val pictureOfTheDayLiveData = MutableLiveData<PictureOfDay>()

    fun getPictureOfTheDayLiveData(): LiveData<PictureOfDay>{
        return pictureOfTheDayLiveData
    }

    init {
        syncAsteroids()
        syncPictureOfTheDay()
        CoroutineScope(Dispatchers.Default).launch {
            refreshAsteroidsWorkManager.setupRecurringWork()
        }
    }


    fun retry(): RetryCallback{
        return object : RetryCallback {
            override fun invoke() {
                syncAsteroids(true)
            }
        }
    }

    fun syncAsteroids(isForceLoad: Boolean = false){
        viewModelScope.launch(Dispatchers.IO) {
            syncData {
                asteroidsUseCases.getWeekAsteroids.getWeekAsteroids(isForceLoad)
            }
        }
    }

    fun syncTodayAsteroids(){
        viewModelScope.launch(Dispatchers.IO) {
            syncData {
                asteroidsUseCases.getTodayAsteroidsData.getTodayAsteroidsData()
            }
        }
    }

    fun syncCachedAsteroids(){
        viewModelScope.launch(Dispatchers.IO) {
            syncData {
                asteroidsUseCases.getCachedAsteroidsData.getCachedAsteroidsData()
            }
        }
    }

    suspend fun syncData(filterCriteria : suspend () -> List<NearEarth>){
        viewModelScope.launch(Dispatchers.IO) {
            listOfNearestEarthObjects.postValue(Result.Loading)
                try {
                    val result = filterCriteria.invoke()
                    listOfNearestEarthObjects.postValue(Result.Success(result))
                } catch (e: Exception) {
                    listOfNearestEarthObjects.postValue(Result.Error(e))
                }
        }
    }

    private fun syncPictureOfTheDay(){
        viewModelScope.launch {
                try {
                    val result = asteroidsUseCases.getPictureOfTheDayUseCase.getPictureOfDay()
                    pictureOfTheDayLiveData.postValue(result)
                }catch (e: Exception){
                    pictureOfTheDayLiveData.postValue(PictureOfDay())
                }
        }
    }

    fun syncSelectedNearEarthObject(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            selectedNearestEarthObject.postValue(Result.Loading)
            try {
                val result = asteroidsUseCases.getAsteroidByIdUseCase.getCachedAsteroidsData(id)
                selectedNearestEarthObject.postValue(Result.Success(result))
            } catch (e: Exception) {
                selectedNearestEarthObject.postValue(Result.Error(e))
            }
        }
    }

    fun getSelectedNearEarthLiveData() = selectedNearestEarthObject
}