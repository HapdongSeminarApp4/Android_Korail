package com.example.korail_aos.presentation.train

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.korail_aos.R
import com.example.korail_aos.databinding.ActivityMainDrawerBinding

private lateinit var binding: ActivityMainDrawerBinding
class DrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_drawer)
    }
}
