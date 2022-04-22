package com.example.kotlinbase.repository

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWorldWeatherFromLocalStorage():List<Weather>
    fun getRussianWeatherFromLocalStorage():List<Weather>
}