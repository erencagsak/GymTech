package com.eren.gymtech.activity

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.eren.gymtech.R
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
            R.id.navUsers ->
                {
                    Toast.makeText(this,"Users",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navPrices ->
                {
                    Toast.makeText(this,"Prices",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navExercise ->
                {
                    Toast.makeText(this,"Exercise",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navAboutUs ->
                {
                    Toast.makeText(this,"AboutUs",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navPhone ->
                {
                    Toast.makeText(this,"Phone",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navExit ->
                {
                    Toast.makeText(this,"Exit",Toast.LENGTH_LONG).show()

                    if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                }
            R.id.navAccount ->
            {
                Toast.makeText(this,"Account",Toast.LENGTH_LONG).show()

                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
        }
        return true
    }
}