package com.example.korail_aos.presentation.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.korail_aos.R
import com.example.korail_aos.databinding.FragmentTicketBinding
import com.google.android.material.tabs.TabLayout

class TicketFragment : Fragment() {
    private var _binding: FragmentTicketBinding? = null
    private val binding: FragmentTicketBinding
        get() = requireNotNull(_binding) { "FragmentTicketBinding" }
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = binding.tlTicketTablayout
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ticket_verify))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ticket_pass))

        binding.tlTicketTablayout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                // 탭의 상태가 선택으로 변경
                override fun onTabSelected(tab: TabLayout.Tab?) {
                }

                // 탭의 상태가 선택되지 않음으로 변경
                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                // 이미 선택된 탭이 다시 선택됨
                override fun onTabReselected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0 -> TicketVerifyFragment()
                        else -> TicketPassFragment()
                    }
                }
            })
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
