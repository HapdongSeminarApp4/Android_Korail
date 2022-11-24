package com.example.korail_aos.presentation.train

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.korail_aos.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_train, container, false)
    }
}
