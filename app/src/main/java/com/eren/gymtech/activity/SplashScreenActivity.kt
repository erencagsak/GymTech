package com.eren.gymtech.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.eren.gymtech.R

class SplashScreenActivity : AppCompatActivity() {
    private var mDelayHandler : Handler? = null
    private val splashDelay : Long = 4400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mRunnable,splashDelay)
    }

    private val mRunnable : Runnable = Runnable{
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}