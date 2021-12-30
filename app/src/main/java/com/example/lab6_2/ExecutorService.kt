package com.example.lab6_2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import java.net.URL

class ExecutorService : AppCompatActivity() {
    private val TAG = "state"
    private val url =
        "https://wallpaper.ru/images/detailed/2/2-072.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val picture = findViewById<ImageView>(R.id.image)
        MyApplication().executor.execute {
            Log.d(TAG, "Executor service execute")
            val url = URL(url)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread {
//              Picasso.get().load(url).into(picture)
                picture.setImageBitmap(bitmap)
                Log.d(TAG, "Download picture")
            }
        }
    }
}