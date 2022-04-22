package com.example.kotlinbase.repository

class RepositoryImpl:Repository {
    override fun getWeatherFromServer():Weather {
        Thread.sleep(2000L) // эмуляция сетевого запроса
        return Weather()
    }

    override fun getWorldWeatherFromLocalStorage()= getWorldCities()

    override fun getRussianWeatherFromLocalStorage()= getRussianCities()
}