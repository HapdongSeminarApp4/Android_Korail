package com.example.korail_aos.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.korail_aos.data.entity.response.ResponseUserTicketDTO
import com.example.korail_aos.data.service.KorailService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TicketVerifyViewModel : ViewModel() {
    private val _getTicketResult: MutableLiveData<ResponseUserTicketDTO> = MutableLiveData()
    val getTicketResult: LiveData<ResponseUserTicketDTO> = _getTicketResult

    private val _successGetTicket: MutableLiveData<Boolean> = MutableLiveData()
    val successGetTicket: LiveData<Boolean> = _successGetTicket

    @Inject
    lateinit var korailService: KorailService

    fun getTicket(userId: Int) {
        korailService.getUserTicket(userId).enqueue(object : Callback<ResponseUserTicketDTO> {
            override fun onResponse(
                call: Call<ResponseUserTicketDTO>,
                response: Response<ResponseUserTicketDTO>
            ) {
                if (response.isSuccessful) {
                    _getTicketResult.value = response.body()
                    _successGetTicket.value = true
                } else {
                    _successGetTicket.value = false
                }
            }

            override fun onFailure(call: Call<ResponseUserTicketDTO>, t: Throwable) {
                _successGetTicket.value = false
            }
        })
    }
}
