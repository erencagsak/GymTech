package com.eren.gymtech.manager

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.CheckBox
import com.eren.gymtech.databinding.ActivityLoginBinding

class SessionManager(private var _context : Context) {
    private var pref: SharedPreferences = _context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = pref.edit()

    internal var PRIVATE_MODE = 0

    val isLoggedIn : Boolean
    get() = pref.getBoolean(KEY_IS_LOGGED_IN, false)

    fun setLogin(isLoggedIn : Boolean){
//        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.commit()

        Log.d(TAG, "Kullanıcı girişi algılandı !")
    }

    companion object{
        private val TAG = SessionManager::class.java.simpleName
        private val PREF_NAME = "Login"
        var KEY_USER_ID = "user_id"
        private val KEY_IS_LOGGED_IN = "isLoggedIn"
    }
}