package com.example.kotlinbase.repository

import android.os.Handler
import android.os.Looper
import com.example.kotlinbase.BuildConfig
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

class WeatherLoader (private val onServerResponseListener: OnServerResponse) {


    fun loadWeather(lat: Double, lon: Double) {

        val urlText = "https://api.weather.yandex.ru/v2/informers?lat=$lat&lon=$lon"
        val uri = URL(urlText)
        thread {
            lateinit var urlConnection: HttpsURLConnection
            try {
                urlConnection =
                    (uri.openConnection() as HttpsURLConnection).apply {
                        requestMethod = "GET"
                        connectTimeout = 1000
                        readTimeout = 1000
                        addRequestProperty("X-Yandex-API-Key", BuildConfig.WEATHER_API_KEY)
                    }

                    val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)
                    Handler(Looper.getMainLooper()).post {
                        onServerResponseListener.onResponse(weatherDTO)
                    }
            } catch (e: Exception) {
                e.toString()
            } finally {
                urlConnection.disconnect()
            }
        }
    }
}