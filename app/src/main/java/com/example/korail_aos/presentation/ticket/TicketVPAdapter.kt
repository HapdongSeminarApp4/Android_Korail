package com.example.korail_aos.presentation.ticket

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TicketVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TicketVerifyFragment()
            else -> TicketPassFragment()
        }
    }
}
