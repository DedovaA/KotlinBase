package com.example.kotlinbase.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

const val KEY_BUNDLE_WEATHER = "key"

fun View.showLongSnackBar(msg: String){
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()
}