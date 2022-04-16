package com.example.kotlinbase

import com.example.kotlinbase.model.Weather

sealed class AppState {
    object Loading:AppState()
    data class Success(val weatherList:List<Weather>):AppState(){
        fun test(){}
    }
    data class Error(val error:Throwable):AppState()
}