package com.example.korail_aos.presentation.train

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.korail_aos.R
import com.example.korail_aos.data.service.KorailService
import com.example.korail_aos.databinding.FragmentTrainBinding
import com.example.korail_aos.presentation.information.InformationActivity
import com.example.korail_aos.remote.ResponseMainDto
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class TrainFragment : Fragment() {
    private var _binding: FragmentTrainBinding? = null
    private val binding: FragmentTrainBinding
        get() = requireNotNull(_binding) { "FragmentTrainBinding" }

    @Inject
    lateinit var korailService: KorailService

    fun onBind(data: ResponseMainDto.Data) {
        binding.tvFrom.text = data.from
        binding.tvTo.text = data.to
        binding.tvDate.text = data.date
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.menu_main_toolbar, menu)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        korailService.getTicket().enqueue(object : Callback<ResponseMainDto> {
            override fun onResponse(
                call: Call<ResponseMainDto>,
                response: Response<ResponseMainDto>
            ) {
                if (response.isSuccessful) { // response의 status code가 200~299 사이의
                    onBind(response.body()!!.data)
                    val result = response.body()!!.data
                    binding.tvDate.text = changeDateFormat(result.date, TrainFragment.DATE_DOW)
                }
            }

            override fun onFailure(call: Call<ResponseMainDto>, t: Throwable) {
                Toast.makeText(requireContext(), "에러 발생", Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnBook.setOnClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            startActivity(intent)
        }

        binding.btnDrawer.setOnClickListener {
            val intent = Intent(context, DrawerActivity::class.java)
            startActivity(intent)
        }
    }
    private fun changeDateFormat(date: String, type: Int): String {
        val timestamp = Instant.parse(date)
        val dateString = Date.from(timestamp)

        return when (type) {
            TrainFragment.DATE_DOW -> SimpleDateFormat("yyyy년 MM월 dd일 (E)", Locale("ko", "KR")).format(dateString)
            else -> SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("ko", "KR")).format(dateString)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_drawer -> {
                binding.navMainDrawer.openDrawer(Gravity.RIGHT)
                binding.navMainDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val DATE_DOW = 0
    }
}
