package com.example.korail_aos.presentation.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.korail_aos.databinding.FragmentTicketVerifyBinding

class TicketVerifyFragment : Fragment() {
    private var _binding: FragmentTicketVerifyBinding? = null
    private val binding: FragmentTicketVerifyBinding
        get() = requireNotNull(_binding) { "FragmentTicketVerifyBinding" }
    private val viewModel by viewModels<TicketVerifyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getUserTicket()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getUserTicket() {
        viewModel.getTicket(2)
        viewModel.successGetTicket.observe(viewLifecycleOwner) { success ->
            if (success) {
                val result = viewModel.getTicketResult.value!!.data[0]
                with(binding) {
                    tvTicketVerifyStartDate.text = result.startDate
                    tvTicketVerifyEndDate.text = result.endDate
                    tvTicketVerifyUserName.text = result.name
                    tvTicketVerifyUserInfo.text = result.gender + result.birth
                    tvTicketVerifyTicketNumContent.text = result.ticketNum
                    tvTicketVerifyDate.text = result.currentDate
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
