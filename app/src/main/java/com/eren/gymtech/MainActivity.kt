package com.eren.gymtech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.eren.gymtech.activity.SplashScreenActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,SplashScreenActivity::class.java)
        startActivity(intent)
        finish()
    }
}