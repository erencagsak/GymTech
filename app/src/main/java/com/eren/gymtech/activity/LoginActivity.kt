package com.eren.gymtech.activity

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.airbnb.lottie.LottieAnimationView
import com.eren.gymtech.R
import com.eren.gymtech.databinding.ActivityLoginBinding
import com.eren.gymtech.global.DB
import com.eren.gymtech.manager.SessionManager


class LoginActivity : AppCompatActivity() {
    var db : DB? = null
    var session : SessionManager? = null

    var username : EditText? = null
    var password : EditText? = null
    var passwordTick : LottieAnimationView? = null
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DB(this)
        session = SessionManager(this)
        username = binding.Username
        password = binding.Password

        binding.Login.setOnClickListener{
            if (validDateLogin()){
                getLogin()
            }
        }

        // Yeşil tik kodları
        login_username_tick()
        login_password_tick()


        binding.ForgotPassword.setOnClickListener{

        }
    }

    private fun getLogin(){
        try {
            val sqlQuery = "SELECT * FROM ADMIN WHERE USER_NAME='"+username?.text.toString().trim()+"' AND PASSWORD = '"+password?.text.toString().trim()+"' AND ID = '1'"
            db?.fireQuery(sqlQuery)?.use{
                if (it.count > 0){
                    session?.setLogin(true)
                    Toast.makeText(this,"Başarıyla giriş yapıldı",Toast.LENGTH_LONG).show()
                    val intent = Intent(this,AdminHomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    session?.setLogin(false)
                    Toast.makeText(this,"Giriş yapılamadı, lütfen daha sonra tekrar deneyiniz...",Toast.LENGTH_LONG).show()
                }
            }
        }
        catch (e : Exception){
            e.printStackTrace()
        }
    }

    private fun validDateLogin() : Boolean{
        if (username?.text.toString().trim().isEmpty()){
            Toast.makeText(this,"Kullanıcı adınızı giriniz...",Toast.LENGTH_LONG).show()
            return false
        }
        else if(password?.text.toString().trim().isEmpty()){
            Toast.makeText(this,"Şifrenizi giriniz...",Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun login_username_tick(){
        val animation_tick: EditText = findViewById(R.id.Username)
        val animationView: LottieAnimationView = findViewById(R.id.login_username_tick)

        var isAnimationPlaying = false // Animasyonun oynatılıp oynatılmadığını izlemek için bir değişken
        val handler = Handler(Looper.getMainLooper())
        animation_tick.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                val isTextNotEmpty = editable.isNotEmpty()

                if (isTextNotEmpty && !isAnimationPlaying) {
                    animationView.visibility = View.VISIBLE
                    animationView.playAnimation()
                    isAnimationPlaying = true

                    handler.postDelayed({
                        animationView.pauseAnimation()
                    }, 1790)

                } else if (!isTextNotEmpty && isAnimationPlaying) {
                    animationView.visibility = View.INVISIBLE
                    animationView.pauseAnimation()
                    isAnimationPlaying = false
                }
            }
        })
    }

    private fun login_password_tick(){
        val animation_tick: EditText = findViewById(R.id.Password)
        val animationView: LottieAnimationView = findViewById(R.id.login_password_tick)

        var isAnimationPlaying = false // Animasyonun oynatılıp oynatılmadığını izlemek için bir değişken
        val handler = Handler(Looper.getMainLooper())
        animation_tick.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                val isTextNotEmpty = editable.isNotEmpty()

                if (isTextNotEmpty && !isAnimationPlaying) {
                    animationView.visibility = View.VISIBLE
                    animationView.playAnimation()
                    isAnimationPlaying = true

                    handler.postDelayed({
                        animationView.pauseAnimation()
                    }, 1790)

                } else if (!isTextNotEmpty && isAnimationPlaying) {
                    animationView.visibility = View.INVISIBLE
                    animationView.pauseAnimation()
                    isAnimationPlaying = false
                }
            }
        })
    }
}