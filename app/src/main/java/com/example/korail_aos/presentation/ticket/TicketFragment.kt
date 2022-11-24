package com.example.korail_aos.presentation.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.korail_aos.R
import com.example.korail_aos.databinding.FragmentTicketBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketFragment : Fragment() {
    private var _binding: FragmentTicketBinding? = null
    private val binding: FragmentTicketBinding
        get() = requireNotNull(_binding) { "FragmentTicketBinding" }
    private val information: Array<String>
        get() = resources.getStringArray(R.array.ticket_array)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViewPager()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setViewPager() {
        val ticketAdapter = TicketVPAdapter(this)
        binding.vpTicketVerifyViewpager.apply {
            adapter = ticketAdapter
            isUserInputEnabled = false
        }
        setTabLayout()
    }

    private fun setTabLayout() {
        TabLayoutMediator(
            binding.tlTicketTablayout,
            binding.vpTicketVerifyViewpager
        ) { tab, position ->
            tab.text = information[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
