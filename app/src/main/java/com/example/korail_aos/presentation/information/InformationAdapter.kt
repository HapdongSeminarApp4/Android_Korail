package com.example.korail_aos.presentation.information

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.korail_aos.databinding.ItemInformationFirstBinding
import com.example.korail_aos.databinding.ItemInformationFiveBinding
import com.example.korail_aos.databinding.ItemInformationFourthBinding
import com.example.korail_aos.databinding.ItemInformationSecondBinding
import com.example.korail_aos.databinding.ItemInformationThirdBinding

class InformationAdapter :
    ListAdapter<Information, InformationViewHolder>(informationDiffCallBack) {
    private lateinit var inflater: LayoutInflater
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> FIRST
            1 -> SECOND
            2 -> THIRD
            3 -> FOURTH
            else -> FIVE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        if (!::inflater.isInitialized) inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            FIRST -> InformationFirstViewHolder(
                ItemInformationFirstBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            SECOND -> InformationSecondViewHolder(
                ItemInformationSecondBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            THIRD -> InformationThirdViewHolder(
                ItemInformationThirdBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            FOURTH -> InformationFourthViewHolder(
                ItemInformationFourthBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> InformationFiveViewHolder(
                ItemInformationFiveBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        when (holder) {
            is InformationFirstViewHolder -> Unit
            is InformationSecondViewHolder -> Unit
            is InformationThirdViewHolder -> Unit
            is InformationFourthViewHolder -> Unit
            is InformationFiveViewHolder -> Unit
        }
    }

    companion object {
        private val informationDiffCallBack = object : DiffUtil.ItemCallback<Information>() {
            override fun areItemsTheSame(oldItem: Information, newItem: Information): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Information, newItem: Information): Boolean =
                oldItem == newItem
        }
        private const val FIRST = 0
        private const val SECOND = 1
        private const val THIRD = 2
        private const val FOURTH = 3
        private const val FIVE = 4
    }
}
