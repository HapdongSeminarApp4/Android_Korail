package com.example.korail_aos.presentation.information

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.korail_aos.R
import com.example.korail_aos.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    private lateinit var informationAdapter: InformationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information)
        initAdapter()
    }

    private fun initAdapter() {
        informationAdapter = InformationAdapter()
        informationAdapter.submitList(dummy)
        binding.vpInformationPages.adapter = informationAdapter
        binding.vpInformationPages.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    companion object {
        private val dummy =
            listOf(Information(0), Information(1), Information(2), Information(3), Information(4))
    }
}

data class Information(
    val id: Int
)
