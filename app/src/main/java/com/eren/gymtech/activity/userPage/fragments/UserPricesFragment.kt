package com.eren.gymtech.activity.userPage.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.eren.gymtech.R
import com.eren.gymtech.activity.userPage.membershipPrice.UserGoldActivity
import com.eren.gymtech.activity.userPage.membershipPrice.UserSilverActivity

class UserPricesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_prices, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerGold = view.findViewById<Button>(R.id.registerGold)
        val registerSilver = view.findViewById<Button>(R.id.registerSilver)

        registerGold.setOnClickListener {
            val intent = Intent(activity, UserGoldActivity::class.java)
            startActivity(intent)
        }

        registerSilver.setOnClickListener {
            val intent = Intent(activity, UserSilverActivity::class.java)
            startActivity(intent)
        }
    }
}