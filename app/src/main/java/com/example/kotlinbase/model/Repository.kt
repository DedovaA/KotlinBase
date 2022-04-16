package com.example.kotlinbase.model

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWorldWeatherFromLocalStorage():List<Weather>
    fun getRussianWeatherFromLocalStorage():List<Weather>
}