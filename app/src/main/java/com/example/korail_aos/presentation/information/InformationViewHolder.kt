package com.example.korail_aos.presentation.information

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.korail_aos.databinding.ItemInformationFirstBinding
import com.example.korail_aos.databinding.ItemInformationFiveBinding
import com.example.korail_aos.databinding.ItemInformationFourthBinding
import com.example.korail_aos.databinding.ItemInformationSecondBinding
import com.example.korail_aos.databinding.ItemInformationThirdBinding

abstract class InformationViewHolder(binding: View) : RecyclerView.ViewHolder(binding)

class InformationFirstViewHolder(private val binding: ItemInformationFirstBinding) :
    InformationViewHolder(binding.root)

class InformationSecondViewHolder(private val binding: ItemInformationSecondBinding) :
    InformationViewHolder(binding.root)

class InformationThirdViewHolder(private val binding: ItemInformationThirdBinding) :
    InformationViewHolder(binding.root)

class InformationFourthViewHolder(private val binding: ItemInformationFourthBinding) :
    InformationViewHolder(binding.root)

class InformationFiveViewHolder(private val binding: ItemInformationFiveBinding) :
    InformationViewHolder(binding.root)
