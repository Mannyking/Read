package com.portfolio.read

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.portfolio.read.databinding.ActivityMainBinding
import com.portfolio.read.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val userViewModel = UserViewModel()
        binding.viewModel = userViewModel
        binding.lifecycleOwner = this // Needed for LiveData updates
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle click on Home item
                    // Example: switchFragment(HomeFragment())
                    true
                }
                R.id.navigation_settings -> {
                    // Handle click on Dashboard item
                    // Example: switchFragment(DashboardFragment())
                    true
                }
                R.id.navigation_profile -> {
                    // Handle click on Dashboard item
                    // Example: switchFragment(DashboardFragment())
                    true
                }
                // Add cases for other menu items as needed
                else -> false
            }
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation item clicks here
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle home click
                }
                R.id.nav_library -> {
                    // Handle library click
                }
                // Add cases for other navigation items
            }

            // Close the drawer after item selection
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}