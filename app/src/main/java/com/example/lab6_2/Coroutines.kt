package com.example.lab6_2

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

@DelicateCoroutinesApi
class Coroutines : AppCompatActivity(){
    private val url =
        "https://wallpaper.ru/images/detailed/2/2-072.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        val picture = findViewById<ImageView>(R.id.image)
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
           val url = URL(url)
           val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
           runOnUiThread {
               picture.setImageBitmap(bitmap)
           }
        }
    }
}