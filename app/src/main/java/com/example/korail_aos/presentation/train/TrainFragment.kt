package com.example.korail_aos.presentation.train

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.korail_aos.R
import com.example.korail_aos.databinding.FragmentTrainBinding
import com.example.korail_aos.remote.MainAdapter
import com.example.korail_aos.remote.MainService
import com.example.korail_aos.remote.MainServicePool
import com.example.korail_aos.remote.ResponseMainDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrainFragment : Fragment() {
    private var _binding: FragmentTrainBinding? = null
    private val binding: FragmentTrainBinding
        get() = _binding!!

    @Inject
    lateinit var MainService: MainService
    private val mainService = MainServicePool.mainService
    private lateinit var mainAdapter: MainAdapter
    var isDrawerOpen = false

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
    ): View {
        _binding = FragmentTrainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_toolbar_drawer -> {
               //drawer 열기
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
