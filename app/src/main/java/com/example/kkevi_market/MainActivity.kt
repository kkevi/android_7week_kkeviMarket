package com.example.kkevi_market

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
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
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }

        mainAdapter.itemClick = object : MainAdaptor.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra("data", fakeDataList[position])
                startActivity(intentDetail)
            }
        }

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("나가기")
                    .setMessage("앱을 종료 하시겠습니까?")
                    .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                        finish()
                    })
                    .setNegativeButton("취소", null)
                    .show()
                this.isEnabled = false
                onBackPressedDispatcher.onBackPressed()
            }
        }

    private fun sendNotification() {

    }
}