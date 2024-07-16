package com.example.kkevi_market

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kkevi_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList = mutableListOf<MainListViewItemData>()

//        dataList.add(MainListViewItemData(123, "Bella", "1", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Charlie", "2", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Daisy", "1.5", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Duke", "1", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Max", "2", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Happy", "4", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Luna", "3", 123, 1, 3))
//        dataList.add(MainListViewItemData(123, "Bob", "2", 123, 1, 3))
    }
}