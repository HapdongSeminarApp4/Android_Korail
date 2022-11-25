package com.example.korail_aos.presentation.ticket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.korail_aos.data.entity.response.ResponseUserTicketDto
import com.example.korail_aos.data.service.KorailService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TicketVerifyViewModel @Inject constructor(
    private var korailService: KorailService
) : ViewModel() {
    private val _getTicketResult: MutableLiveData<ResponseUserTicketDto> = MutableLiveData()
    val getTicketResult: LiveData<ResponseUserTicketDto> = _getTicketResult
    private val _isEmpty: MutableLiveData<Boolean> = MutableLiveData()
    val isEmpty: LiveData<Boolean> = _isEmpty

    fun getTicket(userId: Int) {
        korailService.getUserTicket(userId).enqueue(object : Callback<ResponseUserTicketDto> {
            override fun onResponse(
                call: Call<ResponseUserTicketDto>,
                response: Response<ResponseUserTicketDto>
            ) {
                if (response.isSuccessful) {
                    _getTicketResult.value = response.body()
                    _isEmpty.value = false
                    Log.d("TEST", "getUserTicket 성공, ${response.message()}")
                } else {
                    Log.d("TEST", "getUserTicket 실패, ${response.message()}")
                    _isEmpty.value = true
                }
            }

            override fun onFailure(call: Call<ResponseUserTicketDto>, t: Throwable) {
                _isEmpty.value = true
                Log.d("TEST", "서버 통신 실패, $t")
            }
        })
    }
}
