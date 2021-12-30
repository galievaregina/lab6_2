package com.example.lab6_2

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL

@DelicateCoroutinesApi
class Coroutines : AppCompatActivity(){
    private val TAG = "state"
    private val url =
        "https://wallpaper.ru/images/detailed/2/2-072.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        val picture = findViewById<ImageView>(R.id.image)
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO){
            Log.d(TAG, "Thread launched")
           val url = URL(url)
           val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            withContext(Dispatchers.Main){
                picture.setImageBitmap(bitmap)
                Log.d(TAG, "Download picture")
            }
        }
        Log.d(TAG, "Activity created")
    }
}