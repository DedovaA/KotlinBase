package com.example.kotlinbase.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlinbase.repository.Weather

class WeatherDiffCallback(
    private val oldWeather: List<Weather>,
    private val newWeather: List<Weather>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldWeather.size
    }

    override fun getNewListSize(): Int {
        return newWeather.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldWeather[oldItemPosition].city == newWeather[newItemPosition].city
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldWeather[oldItemPosition] == newWeather[newItemPosition]
    }
}