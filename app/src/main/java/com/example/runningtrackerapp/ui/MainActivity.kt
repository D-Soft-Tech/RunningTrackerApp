package com.example.runningtrackerapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navCon = findNavController(R.id.nav_host_frag)
        bottomNav = binding.bottomNav

        bottomNav.setupWithNavController(navCon)

        navCon.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.setupFragment, R.id.trackingFragment -> {
                    bottomNav.visibility = View.GONE
                } else -> bottomNav.visibility = View.VISIBLE
            }
        }
    }
}
