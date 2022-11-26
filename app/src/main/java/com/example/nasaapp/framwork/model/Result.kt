package com.example.nasaapp.framwork.model

sealed class Result<out T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Error(val exception: Throwable? = null) : Result<Nothing>()

    object Loading : Result<Nothing>()

    fun isSuccessful(): Boolean{
        return this is Success
    }

    fun isFailed(): Boolean{
        return this is Error
    }

    fun isLoading(): Boolean{
        return this is Loading
    }

    fun isEmpty(): Boolean{
        if (this is Success){
            return if (this.data == null){
                true
            }else
                this.data is List<*> && this.data.isEmpty()
        }

        return true
    }
}

 fun <T> Result<T>.getData(): T?{
     if (this is Result.Success)
         return this.data

     return null
}

