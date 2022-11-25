package com.example.korail_aos.presentation.information

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.korail_aos.MainActivity
import com.example.korail_aos.R
import com.example.korail_aos.data.entity.request.TicketRequest
import com.example.korail_aos.data.service.KorailService
import com.example.korail_aos.databinding.ActivityInformationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class InformationActivity : AppCompatActivity() {
    @Inject
    lateinit var korailService: KorailService
    private lateinit var binding: ActivityInformationBinding
    private lateinit var informationAdapter: InformationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information)
        initAdapter()
        initAgreeBtnOnClick()
        initDisagreeBtnOnClick()
        initBackBtnOnClick()
        initPageBtnOnClick()
        initPageBtnVisibility()
    }

    private fun initAdapter() {
        informationAdapter = InformationAdapter()
        informationAdapter.submitList(dummy)
        binding.vpInformationPages.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = informationAdapter
            isUserInputEnabled = false
        }
    }

    private fun initPageBtnVisibility() {
        with(binding) {
            vpInformationPages.registerOnPageChangeCallback(object :
                    ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        ibPrevPage.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
                        llInformationAgreeBtn.visibility =
                            if (position == 4) View.VISIBLE else View.GONE
                        llInformationPageBtn.visibility = if (position == 4) View.GONE else View.VISIBLE
                        tvCurrentPage.text =
                            String.format(getString(R.string.information_current_page), position + 1)
                    }
                })
        }
    }

    private fun initPageBtnOnClick() {
        binding.ibNextPage.setOnClickListener { binding.vpInformationPages.currentItem += 1 }
        binding.ibPrevPage.setOnClickListener { binding.vpInformationPages.currentItem -= 1 }
    }

    private fun initDisagreeBtnOnClick() {
        binding.btnDisagree.setOnClickListener { finish() }
    }

    private fun initAgreeBtnOnClick() {
        binding.btnAgree.setOnClickListener {
            postTicket()
        }
    }

    private fun postTicket() {
        lifecycleScope.launch {
            runCatching { korailService.postTicket(TicketRequest(1, 2, "5A", 5)) }
                .onSuccess { moveMainActivity() }
                .onFailure { Log.e(TAG, "error : ${it.message}") }
        }
    }

    private fun moveMainActivity() {
        Intent(this, MainActivity::class.java)
            .apply { putExtra("moveTicket", true) }
            .also { intent ->
                startActivity(intent)
                finishAffinity()
            }
    }

    private fun initBackBtnOnClick() {
        binding.includeInformationToolBar.ibBackBtn.setOnClickListener { finish() }
    }

    companion object {
        private val dummy =
            listOf(Information(0), Information(1), Information(2), Information(3), Information(4))
        private const val TAG = "InformationActivity"
    }
}

data class Information(
    val id: Int
)
