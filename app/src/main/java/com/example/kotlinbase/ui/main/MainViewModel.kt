package com.example.kotlinbase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinbase.AppState
import com.example.kotlinbase.repository.RepositoryImpl
import kotlin.concurrent.thread

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImpl = RepositoryImpl()
) :
    ViewModel() {
    //getter for LiveData
    fun getData(): LiveData<AppState> {
        return liveData
    }

//запрос данных выполняется в отдельном потоке, но liveData должна обновляться в главном , поэтому
//вызываем .postValue()
    private fun getWeather(isRussian:Boolean) {
        thread {
            liveData.postValue(AppState.Loading)
//            if (true){
                val answer = if(!isRussian) repository.getWorldWeatherFromLocalStorage()
                            else repository.getRussianWeatherFromLocalStorage()
                liveData.postValue(AppState.Success(answer))
//            }
//            else
//                liveData.postValue(AppState.Error(IllegalAccessException()))
        }
    }

    fun getWeatherRussia() = getWeather(true)
    fun getWeatherWorld() = getWeather(false)

}
