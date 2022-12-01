package com.example.korail_aos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.korail_aos.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initBottomNavigationView()
        moveTicketScreen()
    }

    private fun moveTicketScreen() {
        val isMove = intent.getBooleanExtra("moveTicket", false)
        if (isMove) binding.botNavMain.selectedItemId = R.id.ticketFragment
    }

    private fun initBottomNavigationView() {
        val navController = findNavController()
        binding.botNavMain.setupWithNavController(navController)
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fc_main) as NavHostFragment
        return navHostFragment.navController
    }
}
