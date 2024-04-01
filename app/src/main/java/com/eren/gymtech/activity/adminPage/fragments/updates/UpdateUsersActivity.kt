package com.eren.gymtech.activity.adminPage.fragments.updates

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eren.gymtech.R
import com.eren.gymtech.databinding.ActivityUpdateUsersBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateUsersActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateUsersBinding
    private lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName")
        val userSurname = intent.getStringExtra("userSurname")
        val userBirthDate = intent.getStringExtra("userBirthDate")
        val userMail = intent.getStringExtra("userMail")
        val userUid = intent.getStringExtra("userUid")

        val userNameEditText = findViewById<EditText>(R.id.UserName)
        val userSurnameEditText = findViewById<EditText>(R.id.UserSurname)
        val userBirthDateEditText = findViewById<EditText>(R.id.UserDate)
        val userMailText = findViewById<TextView>(R.id.userMail)
        val userUidText = findViewById<TextView>(R.id.userUid)

        userNameEditText.setText(userName)
        userSurnameEditText.setText(userSurname)
        userBirthDateEditText.setText(userBirthDate)
        userMailText.text = userMail
        userUidText.text = userUid

        binding.UpdateDetails.setOnClickListener {
            updateUsers(userUid.toString(), userMail.toString(),userName.toString(),userSurname.toString())
        }
    }

    private fun updateUsers(userUid : String, userMail: String, userName:String,userSurname:String,){
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        val userData = mapOf<String,String>("userName" to userName, "userSurname" to userSurname)
        databaseReference.child(userUid).updateChildren(userData).addOnSuccessListener {
            binding.UserName.text?.clear()
            binding.UserSurname.text?.clear()
            binding.userRegisterDate.text?.clear()
            binding.userRegisterFinishDate.text?.clear()
            Toast.makeText(this,"Güncellendi",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Bir sorun oluştu, lütfen daha sonra tekrar deneyiniz.",Toast.LENGTH_SHORT).show()
        }
    }
}