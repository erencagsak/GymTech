package com.eren.gymtech.activity.adminPage.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.eren.gymtech.R
import com.eren.gymtech.databinding.FragmentUserAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class AdminAccountFragment : Fragment() {
    private lateinit var binding: FragmentUserAccountBinding
    private lateinit var database: DatabaseReference
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Use ViewBinding to inflate the layout for this fragment
        binding = FragmentUserAccountBinding.inflate(inflater, container, false)

        // Set up onClickListener for the update button
        binding.UpdateDetails.setOnClickListener {
            val date = binding.UserDate.text.toString()
            val firstName = binding.UserName.text.toString()
            val lastName = binding.UserSurname.text.toString()
            val userUidTextView = binding.userUid // This is a TextView, not a String
            val userID = user?.uid

            if (userID != null) {
                userUidTextView.text = userID
                updateData(date, userID, firstName, lastName)
            } else {
                userUidTextView.text = "User ID mevcut değil"
                Toast.makeText(context, "Kullanıcı ID mevcut değil.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.UserDate.setOnClickListener{
            showDatePickerDialog(it)
        }

        return binding.root
    }

    private fun updateData(date : String, userUid : String, firstName: String, lastName: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "userBirthDate" to date,
            "userName" to firstName,
            "userSurname" to lastName
        )
        database.child(userUid).updateChildren(user).addOnSuccessListener {
            binding.UserName.text?.clear()
            binding.UserSurname.text?.clear()
            binding.UserDate.text?.clear()
        }
    }

    fun showDatePickerDialog(view: View) {
        val context = requireContext() // or use getContext() if you prefer
        val datePickerDialog = DatePickerDialog(
            context,
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