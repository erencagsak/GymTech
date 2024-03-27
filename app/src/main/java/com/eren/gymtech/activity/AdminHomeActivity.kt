package com.eren.gymtech.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eren.gymtech.databinding.ActivityAdminhomeBinding

class AdminHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminhomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}