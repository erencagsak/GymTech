package com.eren.gymtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.eren.gymtech.activity.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val splash_delay: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mRunnable,splash_delay)
    }

    private val mRunnable: Runnable = Runnable {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}