package com.eren.gymtech.activity.userPage

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.eren.gymtech.R
import com.eren.gymtech.activity.generalPage.LoginActivity
import com.eren.gymtech.databinding.ActivityUserDetailsBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text
import java.util.Calendar

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var bindingUserDetails : ActivityUserDetailsBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUserDetails = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(bindingUserDetails.root)

        val userEmail = user?.email
        val userMailAdress = findViewById<TextInputEditText>(R.id.UserMail)
        userMailAdress.setText(userEmail)

        val userID = user?.uid
        val userUid = findViewById<TextView>(R.id.userUid)
        userUid.text = userID
        userUid.isInvisible = true


        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()

        bindingUserDetails.UpdateDetails.setOnClickListener {

            val userPassword = bindingUserDetails.UserPassword.text.toString()
            val userName = bindingUserDetails.UserName.text.toString()
            val userSurname = bindingUserDetails.UserSurname.text.toString()
            val userBirthDate = bindingUserDetails.UserDate.text.toString()

            if (userName.isNotEmpty() && userSurname.isNotEmpty() && userBirthDate.isNotEmpty()){
                val userData:HashMap<String , Any> = HashMap()
                userData["userUid"] = userID.toString()
                userData["userMail"] = userEmail.toString()
                userData["userPassword"] = userPassword
                userData["userName"] = userName
                userData["userSurname"] = userSurname
                userData["userBirthDate"] = userBirthDate
                userData["userRegisterDate"] = ""
                userData["userRegisterFinishDate"] = ""
                userData["userIsAMember"] = false

                firebaseDatabase.reference.child("Users").child(userID.toString()).setValue(userData)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Kullanıcı bilgileri başarıyla kaydedildi.",Toast.LENGTH_LONG).show()
                            intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this,"Kullanıcı bilgileri kaydedilirken bir hata oluştu.",Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else
            {
                Toast.makeText(this,"Lütfen boş bir alan bırakmayınız.",Toast.LENGTH_LONG).show()
            }
        }
    }

    // Kullanıcının doğum tarihi için bir takvim çıkarır.
    fun showDatePickerDialog(view: View) {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val formattedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                (view as EditText).setText(formattedDate)
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}