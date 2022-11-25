package com.example.korail_aos.presentation.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.korail_aos.R
import com.example.korail_aos.databinding.FragmentTicketVerifyBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

@AndroidEntryPoint
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
        super.onViewCreated(view, savedInstanceState)
        getUserTicket()
    }

    private fun getUserTicket() {
        viewModel.getTicket(1)
        viewModel.getTicketResult.observe(viewLifecycleOwner) {
            val result = viewModel.getTicketResult.value!!.data[0]
            with(binding) {
                tvTicketVerifyStartDate.text = changeDateFormat(result.startDate, DATE_DOW)
                tvTicketVerifyEndDate.text = changeDateFormat(result.endDate, DATE_DOW)
                tvTicketVerifyUserName.text = result.name
                tvTicketVerifyUserInfo.text = String.format(
                    getString(R.string.ticket_verify_user_info_content),
                    result.gender,
                    changeDateFormat(result.birth, DATE_DEFAULT)
                )
                tvTicketVerifyTicketNumContent.text = result.ticketNum
                tvTicketVerifyDate.text = changeDateFormat(result.currentDate, DATE_TIME)
            }
            setView()
        }
    }

    private fun setView() {
        if (viewModel.isEmpty.value == true) {
            binding.cvTicketVerify.visibility = View.GONE
            binding.clTicketEmpty.visibility = View.VISIBLE
        } else {
            binding.cvTicketVerify.visibility = View.VISIBLE
            binding.clTicketEmpty.visibility = View.GONE
        }
    }

    private fun changeDateFormat(date: String, type: Int): String {
        val timestamp = Instant.parse(date)
        val dateString = Date.from(timestamp)

        return when (type) {
            DATE_DOW -> SimpleDateFormat("yyyy년 MM월 dd일 (E)", Locale("ko", "KR")).format(dateString)
            DATE_DEFAULT -> SimpleDateFormat("yyyy년 MM월 dd일", Locale("ko", "KR")).format(dateString)
            else -> SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ko", "KR")).format(dateString)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DATE_DOW = 0
        private const val DATE_DEFAULT = 1
        private const val DATE_TIME = 2
    }
}
