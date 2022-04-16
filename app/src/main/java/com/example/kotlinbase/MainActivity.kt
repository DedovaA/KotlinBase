package com.example.kotlinbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.kotlinbase.ui.main.DetailsFragment
import com.example.kotlinbase.ui.main.WeatherListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }
//
//
//        val button = Button(this)
//        val view1: View = LinearLayout(this)
//        val view2: View = TextView(this)
//        (view2 as TextView).text = ""
//        someViewGroup((view1 as LinearLayout))


        val looperNotNullable: Looper = getMainLooper()
        val looperNullable: Looper? = getMainLooper()



    }

}