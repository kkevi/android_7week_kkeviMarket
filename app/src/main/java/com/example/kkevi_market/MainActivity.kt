package com.example.kkevi_market

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kkevi_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fakeDataInstance = FakeData.getFakeData()
        val fakeDataList = fakeDataInstance.getFakeDataList()

        val mainAdapter = MainAdaptor(fakeDataList)
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }

        mainAdapter.itemClick = object : MainAdaptor.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra("user", fakeDataList[position])
                startActivity(intentDetail)
            }
        }
    }
}