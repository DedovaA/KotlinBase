package com.example.kotlinbase

import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbase.ui.main.WeatherListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }


        val looperNotNullable: Looper = getMainLooper()
        val looperNullable: Looper? = getMainLooper()



    }

}