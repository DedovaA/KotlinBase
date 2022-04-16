package com.example.kotlinbase.ui.main

import com.example.kotlinbase.model.Weather

interface OnItemListClickListener {
    fun onItemClick(weather: Weather)
}