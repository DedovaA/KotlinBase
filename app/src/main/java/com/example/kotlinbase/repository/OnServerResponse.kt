package com.example.kotlinbase.repository

interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}