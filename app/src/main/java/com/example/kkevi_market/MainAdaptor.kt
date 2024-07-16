package com.example.kkevi_market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kkevi_market.databinding.MainListRecylcerViewBinding

class MainAdaptor(val mItems: MutableList<MainListViewItemData>) :
    RecyclerView.Adapter<MainAdaptor.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdaptor.Holder {
        val binding =
            MainListRecylcerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MainAdaptor.Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class Holder(val binding: MainListRecylcerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
//        val iconImageView = binding.iconItem //이미지 생략
//        val name = binding.textItem1
//        val age = binding.textItem2
    }
}