package com.example.kotlinbase.ui.main

import com.example.kotlinbase.repository.Weather

interface OnItemListClickListener {
    fun onItemClick(weather: Weather)
}