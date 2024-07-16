package com.example.kkevi_market

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class MainListViewItemData (
    val id: Long = 0L,
    val user: User,
    val imageSrc: Int,
    val title: String,
    val contents: String,
    val price: Int,
    val likes: Int = 0,
    val comments: Int = 0,
    val createdDate: LocalDateTime = LocalDateTime.now(),
) : Parcelable {

}