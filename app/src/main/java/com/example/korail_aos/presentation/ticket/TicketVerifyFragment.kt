package com.example.korail_aos.presentation.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.korail_aos.R
import com.example.korail_aos.databinding.FragmentTicketVerifyBinding
import java.text.SimpleDateFormat
import java.util.*

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
                    tvTicketVerifyStartDate.text = changeDateFormat(result.startDate, 0).toString()
                    tvTicketVerifyEndDate.text = changeDateFormat(result.endDate, 0).toString()
                    tvTicketVerifyUserName.text = result.name
                    tvTicketVerifyUserInfo.text = String.format(
                        getString(R.string.ticket_verify_user_info_content),
                        result.gender,
                        changeDateFormat(result.birth, 1)
                    )
                    tvTicketVerifyTicketNumContent.text = result.ticketNum
                    tvTicketVerifyDate.text = changeDateFormat(result.currentDate, 2).toString()
                }
            }
        }
    }

    private fun changeDateFormat(date: Date, type: Int) {
        when (type) {
            0 -> SimpleDateFormat("yyyy년 MM월 dd일 (E)", Locale("ko", "KR")).format(date)
            1 -> SimpleDateFormat("yyyy년 MM월 dd일", Locale("ko", "KR")).format(date)
            else -> SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ko", "KR")).format(date)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
