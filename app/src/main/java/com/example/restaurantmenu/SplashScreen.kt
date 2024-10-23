package com.example.restaurantmenu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this, ViewOrder::class.java)
            j.putExtras(i)
            startActivity(j)
        }, 1000)
    }
}