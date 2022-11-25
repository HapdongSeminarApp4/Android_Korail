package com.example.korail_aos.presentation.train

import androidx.drawerlayout.widget.DrawerLayout
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.korail_aos.R
import com.example.korail_aos.data.service.KorailService
import com.example.korail_aos.databinding.FragmentTrainBinding
import com.example.korail_aos.remote.ResponseMainDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TrainFragment : Fragment() {
    private var _binding: FragmentTrainBinding? = null
    private val binding: FragmentTrainBinding
        get() = requireNotNull(_binding) { "FragmentTrainBinding" }
    @Inject
    lateinit var KorailService: KorailService

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

        KorailService.getTicket().enqueue(object : Callback<ResponseMainDto> {
            override fun onResponse(
                call: Call<ResponseMainDto>,
                response: Response<ResponseMainDto>
            ) {
                if (response.isSuccessful) { // response의 status code가 200~299 사이의
                    onBind(response.body()!!.data[0])
                }
            }
            override fun onFailure(call: Call<ResponseMainDto>, t: Throwable) {
                Toast.makeText(requireContext(), "에러 발생", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_toolbar_drawer -> {
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
}
