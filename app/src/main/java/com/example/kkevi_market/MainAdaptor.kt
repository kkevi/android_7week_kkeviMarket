package com.example.kkevi_market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kkevi_market.databinding.MainListRecylcerViewBinding

class MainAdaptor(private val mItems: List<MainListViewItemData>) :
    RecyclerView.Adapter<MainAdaptor.Holder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdaptor.Holder {
        val binding =
            MainListRecylcerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MainAdaptor.Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.image.setImageResource(mItems[position].imageSrc)
        holder.title.text = mItems[position].title
        holder.location.text = mItems[position].user.location
        holder.price.text = mItems[position].price.toString()
        holder.comments.text = mItems[position].comments.toString()
        holder.likes.text = mItems[position].likes.toString()
    }

    // 아래 2개는 꼭 override 해줘야 함
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        // 리스트 총개수 반환
        return mItems.size
    }

    inner class Holder(private val binding: MainListRecylcerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivItem
        val title = binding.tvTitle
        val location = binding.tvLocation
        val price = binding.tvPrice
        val comments = binding.tvComments
        val likes = binding.tvLike
    }
}