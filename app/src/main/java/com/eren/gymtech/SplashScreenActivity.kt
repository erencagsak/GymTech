package com.eren.gymtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.eren.gymtech.activity.LoginActivity
import com.eren.gymtech.databinding.ActivityMainBinding
import com.eren.gymtech.global.DB
import com.eren.gymtech.manager.SessionManager
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    // Handler Sınıfı
    private var mDelayHandler: Handler? = null
    private val splash_delay: Long = 5000 // milisaniye, 5 saniye

    // Database - SQLite
    var db : DB? = null

    // Oturum yönetimi
    var session : SessionManager? = null

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding ile bağlama işlemi
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Database - SQLite
        db = DB(this)

        // Oturum yönetimi
        session = SessionManager(this)

        insertAdminData()

        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mRunnable,splash_delay)
    }

    // Splash Screen işlemi bitince gösterilecek ekranı seçer
    private val mRunnable: Runnable = Runnable {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    // SQLite database'e veri ekler.
    private fun insertAdminData(){
        try {
            val sqlCheck = "SELECT * FROM ADMIN"
            db?.fireQuery(sqlCheck)?.use {
                if (it.count > 0){
                    Log.d("SplashActivity","Veri mevcut.")
                }
                else{
                    val sqlQuery = "INSERT OR REPLACE INTO ADMIN(ID,USER_NAME,PASSWORD,MOBILE) VALUES('1','Admin','1234','8888')"
                    db?.executeQuery(sqlQuery)
                }
            }
        }
        catch (e : Exception){
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mDelayHandler?.removeCallbacks(mRunnable)
    }
}