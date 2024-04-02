package com.example.dorbbytask.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dorbbytask.R
import com.example.dorbbytask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        initListeners()
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            backBtnPerform()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

   private fun backBtnPerform() {
        navController.popBackStack()
    }

    fun showBackBtn() {
        binding.btnBack.visibility = View.VISIBLE
    }

    fun hideBackBtn() {
        binding.btnBack.visibility = View.GONE
    }

    fun setTitleName(title: String) {
        binding.label.text = title
    }

}