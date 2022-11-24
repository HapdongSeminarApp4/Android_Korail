package com.example.korail_aos.remote

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.korail_aos.presentation.ticket.TicketFragment

class MainAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var mainList: List<ResponseMainDTO> = emptyList()
//    override fun createFragment(position: Int): Fragment {
//        return when (position) {
//            0 -> TicketFragment
//            else -> TYPE_FOLLOWER
//        }
//    }
//    fun onBind(data: ResponseMainDTO.Data) {
//        binding.tvFollowerName.text = data.first_name
//        binding.tvFollowerEmail.text = data.email
//        Glide.with(this.binding.root)
//            .load(data.avatar)
//            .into(binding.ivFollower)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            TYPE_HEADER -> {
//                val binding = ItemFollowerHeaderBinding.inflate(inflater, parent, false)
//                HeaderViewHolder(binding)
//            }
//            TYPE_FOLLOWER -> {
//                val binding = ItemFollowerBinding.inflate(inflater, parent, false)
//                FollowerViewHolder(binding)
//            }
//            else -> throw IllegalArgumentException("view type not found")
//        }
//    }
//    fun setFollowerList(list: List<ResponseMainDTO.Data>) {
//        this.followerList = list.toList()
//        notifyDataSetChanged()
//    }
//    companion object {
//        const val TYPE_HEADER = 0
//        const val TYPE_FOLLOWER = 1
//    }
}