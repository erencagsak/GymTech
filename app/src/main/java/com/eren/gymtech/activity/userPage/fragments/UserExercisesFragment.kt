package com.eren.gymtech.activity.userPage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.eren.gymtech.R
import com.eren.gymtech.activity.userPage.fragments.exercises.AbtFragment
import com.eren.gymtech.activity.userPage.fragments.exercises.ArmFragment
import com.eren.gymtech.activity.userPage.fragments.exercises.BackFragment
import com.eren.gymtech.activity.userPage.fragments.exercises.ChestFragment
import com.eren.gymtech.activity.userPage.fragments.exercises.LegFragment
import com.eren.gymtech.activity.userPage.fragments.exercises.ShoulderFragment

class UserExercisesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user_exercises, container, false)

        val openChestImageView = view.findViewById<ImageView>(R.id.openChest)
        val openArmImageView = view.findViewById<ImageView>(R.id.openArm)
        val openLegImageView = view.findViewById<ImageView>(R.id.openLeg)
        val openBackImageView = view.findViewById<ImageView>(R.id.openBack)
        val openShoulderImageView = view.findViewById<ImageView>(R.id.openShoulder)
        val openAbtImageView = view.findViewById<ImageView>(R.id.openAbt)

        openChestImageView.setOnClickListener {
            val fragment = ChestFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        openArmImageView.setOnClickListener {
            val fragment = ArmFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        openShoulderImageView.setOnClickListener {
            val fragment = ShoulderFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        openLegImageView.setOnClickListener {
            val fragment = LegFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        openBackImageView.setOnClickListener {
            val fragment = BackFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        openAbtImageView.setOnClickListener {
            val fragment = AbtFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}