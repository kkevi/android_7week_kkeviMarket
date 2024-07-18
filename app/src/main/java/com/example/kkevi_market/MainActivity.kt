package com.example.kkevi_market

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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

            override fun onLongClick(view: View, position: Int) {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.apply {
                    setTitle("상품 삭제")
                    setMessage("상품을 정말 삭제 하시겠습니까?")
                    setPositiveButton("확인") { dialog, which ->
                        for ((idx, itm) in fakeDataList.withIndex()) {
                            if (idx == position) {
                                fakeDataList.removeAt(idx)
                                this@MainActivity.runOnUiThread { // 제미나이를 통해 배운 사실 표기
                                    mainAdapter.notifyItemRemoved(idx)
                                }
                                break
                            }
                        }
//                        fakeDataList.forEachIndexed { idx, itm ->
//                            if (idx == position) {
//                                fakeDataList.removeAt(idx)
//                                mainAdapter.notifyItemChanged(idx)
//                            }
//                        }
                    }
                    setNegativeButton("취소", null)
                    show()
                }
            }
        }

        binding.ivNotification.setOnClickListener { createNotificationChannel() }

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

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { //앱이 실행 중일 때 권한 요청
            if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                // 알림 권한이 없다면, 사용자에게 권한 요청
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                }
                startActivity(intent)
            }
        }

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // Android 8.0이상인 경우엔 알림 채널을 먼저 만들어야 함
            val channelID = "one-channel"
            val channelName = " My Channel One"
            val channel = NotificationChannel(
                channelID,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "This is channel description"
                setShowBadge(true)
                enableVibration(true)
            }
            manager.createNotificationChannel(channel) // 채널을 manager 등록

            builder = NotificationCompat.Builder(this, channelID) // 채널을 이용하여 빌드 생성
        } else { // 26버전 이하
            builder = NotificationCompat.Builder(this)
        }

        // 알림 기본 정보
        builder.run {
            setWhen(System.currentTimeMillis()) //알람 발생 시간
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 왔어요!")
            setPriority(NotificationCompat.PRIORITY_DEFAULT)
        }

        manager.notify(11, builder.build())
    }
}