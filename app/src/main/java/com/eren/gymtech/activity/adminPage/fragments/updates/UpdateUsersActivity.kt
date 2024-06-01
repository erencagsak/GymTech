package com.eren.gymtech.activity.adminPage.fragments.updates

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eren.gymtech.R
import com.eren.gymtech.activity.adminPage.AdminHomeActivity
import com.eren.gymtech.activity.adminPage.fragments.AdminUsersFragment
import com.eren.gymtech.databinding.ActivityUpdateUsersBinding
import com.eren.gymtech.databinding.FragmentUserAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class UpdateUsersActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateUsersBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName")
        val userNameEditText = findViewById<EditText>(R.id.UserName)
        userNameEditText.setText(userName)

        val userSurname = intent.getStringExtra("userSurname")
        val userSurnameEditText = findViewById<EditText>(R.id.UserSurname)
        userSurnameEditText.setText(userSurname)

        val userBirthDate = intent.getStringExtra("userBirthDate")
        val userBirthDateEditText = findViewById<EditText>(R.id.UserDate)
        userBirthDateEditText.setText(userBirthDate)

        val userRegisterDate = intent.getStringExtra("userRegisterDate")
        val userRegisterDateEditText = findViewById<EditText>(R.id.userRegisterDate)
        userRegisterDateEditText.setText(userRegisterDate)

        val userRegisterFinishDate = intent.getStringExtra("userRegisterFinishDate")
        val userRegisterFinishDateEditText = findViewById<EditText>(R.id.userRegisterFinishDate)
        userRegisterFinishDateEditText.setText(userRegisterFinishDate)

        val userMail = intent.getStringExtra("userMail")
        val userMailText = findViewById<TextView>(R.id.userMail)
        userMailText.text = userMail

        val userUid = intent.getStringExtra("userUid")
        val userUidText = findViewById<TextView>(R.id.userUid)
        userUidText.text = userUid

        // Geri butonu için OnClickListener ekle
        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener {
            finish()
        }

        // Set up onClickListener for the update button
        binding.UpdateDetails.setOnClickListener {
            val date = binding.UserDate.text.toString()
            val firstName = binding.UserName.text.toString()
            val registerDate = binding.userRegisterDate.text.toString()
            val registerFinishDate = binding.userRegisterFinishDate.text.toString()
            val lastName = binding.UserSurname.text.toString()
            val userUidTextView = binding.userUid.text.toString()

            updateData(date, registerDate, registerFinishDate , userUidTextView, firstName, lastName)

            finish()
        }
    }

    private fun updateData(date : String,registerDate:String,registerFinishDate:String, userUid : String, firstName: String, lastName: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "userBirthDate" to date,
            "userRegisterDate" to registerDate,
            "userRegisterFinishDate" to registerFinishDate,
            "userName" to firstName,
            "userSurname" to lastName
        )
        database.child(userUid).updateChildren(user).addOnSuccessListener {
            binding.UserName.text?.clear()
            binding.userRegisterDate.text?.clear()
            binding.userRegisterFinishDate.text?.clear()
            binding.UserSurname.text?.clear()
            binding.UserDate.text?.clear()
        }
    }

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