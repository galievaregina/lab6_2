package com.example.lab6_2

import android.app.Application
import java.util.concurrent.Executors

class MyApplication: Application() {
    val executor = Executors.newSingleThreadExecutor()
}