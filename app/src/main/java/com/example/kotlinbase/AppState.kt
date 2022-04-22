package com.example.kotlinbase

import com.example.kotlinbase.repository.Weather

/**
 * класс-enum описиывающий состояние приложения
 */

sealed class AppState {
    //не нужно никаких параметров передавать, для отображения прогрессбара, поэтому будет синглтон, а не data class
    object Loading:AppState()
    data class Success(val weatherList:List<Weather>):AppState()
    data class Error(val error:Throwable):AppState()
}