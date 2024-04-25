package com.eren.gymtech.activity.generalPage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eren.gymtech.activity.userPage.UserHomeActivity
import com.eren.gymtech.activity.adminPage.AdminHomeActivity
import com.eren.gymtech.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private val adminUid : String = "M4athnCIWYXuAIfr8PcfD15t69f1"
    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Giriş yap
        login()

        // Kayıt ol butonuna basınca, RegisterActivity'e git
        registerPage()

    }

    // Giriş Yap - Firebase
    private fun login(){
        binding.LoginButton.setOnClickListener {
            val mail = binding.LoginMail.text.toString()
            val password = binding.LoginPassword.text.toString()

            if (mail.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val currentUser = firebaseAuth.currentUser

                        if (currentUser?.uid == adminUid)
                        {
                            Toast.makeText(this,"Giriş başarılı...",Toast.LENGTH_LONG).show()
                            val adminIntent = Intent(this, AdminHomeActivity::class.java)
                            startActivity(adminIntent)
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this,"Giriş başarılı...",Toast.LENGTH_LONG).show()
                            val userIntent = Intent(this, UserHomeActivity::class.java)
                            startActivity(userIntent)
                            finish()
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "E-posta adresiniz ve/veya şifreniz hatalı.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this, "E-Posta veya şifre boş olamaz", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Kayıt olma ekranına yönlendir
    private fun registerPage(){
        binding.RegisterTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}