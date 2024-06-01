package com.eren.gymtech.activity.adminPage

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.eren.gymtech.R
import com.eren.gymtech.activity.adminPage.fragments.AdminAboutUsFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminAccountFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminExercisesFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminHomeFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminPhoneFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminPricesFragment
import com.eren.gymtech.activity.adminPage.fragments.AdminUsersFragment
import com.eren.gymtech.activity.generalPage.LoginActivity
import com.eren.gymtech.activity.userPage.fragments.UserAboutUsFragment
import com.eren.gymtech.activity.userPage.fragments.UserExercisesFragment
import com.eren.gymtech.activity.userPage.fragments.UserPhoneFragment
import com.eren.gymtech.activity.userPage.fragments.UserPricesFragment
import com.eren.gymtech.databinding.ActivityAdminHomeBinding
import com.google.android.material.navigation.NavigationView

class AdminHomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var binding: ActivityAdminHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragments(AdminHomeFragment())

        // NavBar
        setSupportActionBar(binding.homeInclude.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this,drawerLayout,binding.homeInclude.toolbar,R.string.nav_bar_opened,R.string.nav_bar_closed)
        drawerLayout.addDrawerListener(toggle)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.navReturnHomePage ->{
                replaceFragments(AdminHomeFragment())

                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            R.id.navUsers ->
                {
                    replaceFragments(AdminUsersFragment())

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navPrices ->
                {
                    replaceFragments(UserPricesFragment())

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navExercise ->
                {
                    replaceFragments(UserExercisesFragment())

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navAboutUs ->
                {
                    replaceFragments(UserAboutUsFragment())

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navPhone ->
                {
                    replaceFragments(UserPhoneFragment())

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navAccount ->
            {
                replaceFragments(AdminAccountFragment())

                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            R.id.navExit ->
                {
                    logOut()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
        }
        return true
    }

    private fun logOut(){
        intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun replaceFragments(fragment: Fragment)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container,fragment)
        fragmentTransaction.commit()
    }
}