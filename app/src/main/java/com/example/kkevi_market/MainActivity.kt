package com.example.kkevi_market

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kkevi_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fakeData = FakeData.getFakeData()

//        val adapter = MainAdaptor(fakeData.getFakeDataList())
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdaptor(fakeData.getFakeDataList())
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val decoration = DividerItemDecoration(this, )
//        recyclerView.addItemDecoration(decoration)

//        adapter.itemClick = object : MainAdaptor.ItemClick {
//            override fun onClick(view: View, position: Int) {
//
//            }
//        }
    }
}