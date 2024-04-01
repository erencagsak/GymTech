package com.eren.gymtech.activity.generalPage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eren.gymtech.activity.userPage.UserDetailsActivity
import com.eren.gymtech.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.RegisterButton.setOnClickListener {
            val registerMail = binding.RegisterMail.text.toString()
            val registerPassword = binding.RegisterPassword.text.toString()
            val registerRePassword = binding.RegisterRePassword.text.toString()

            if (registerMail.isNotEmpty() && registerPassword.isNotEmpty() && registerRePassword.isNotEmpty()){
                if (registerPassword == registerRePassword){
                    firebaseAuth.createUserWithEmailAndPassword(registerMail,registerPassword).addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this,"Kayıt olma işlemi başarılı...",Toast.LENGTH_LONG).show()
                            val intent = Intent(this, UserDetailsActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else{
                    Toast.makeText(this,"Şifreler eşleşmiyor",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"Bu alan boş bırakılamaz !",Toast.LENGTH_LONG).show()
            }
        }
        binding.LoginTextView.setOnClickListener{
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}