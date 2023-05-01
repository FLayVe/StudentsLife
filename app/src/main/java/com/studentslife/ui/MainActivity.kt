package com.studentslife.ui

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.studentslife.R
import com.studentslife.databinding.ActivityMainBinding
import com.studentslife.ui.stream.BottomNavMenuStream
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var bottomNavMenuStream: BottomNavMenuStream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.bottomMenuStream = bottomNavMenuStream

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)
    }
}