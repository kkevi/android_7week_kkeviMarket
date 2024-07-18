package com.example.kkevi_market

import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kkevi_market.databinding.MainListRecylcerViewBinding

class MainAdaptor(private val mItems: List<MainListViewItemData>) :
    RecyclerView.Adapter<MainAdaptor.Holder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdaptor.Holder {
        val binding =
            MainListRecylcerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MainAdaptor.Holder, position: Int) {
        val dec = DecimalFormat("#,###원")
        val currentItem = mItems[position]

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener{
            itemClick?.onLongClick(it, position)
            true
        }
        holder.image.setImageResource(currentItem.imageSrc)
        holder.title.text = currentItem.title
        holder.location.text = currentItem.user.location
        holder.price.text = dec.format(currentItem.price)
        holder.comments.text = currentItem.comments.toString()
        holder.likes.text = currentItem.likes.toString()
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