package com.example.kkevi_market

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kkevi_market.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val dec = DecimalFormat("#,###원")

        val data = intent.getParcelableExtra<MainListViewItemData>("data")

        binding.apply{
            data?.imageSrc?.let { detailIvImage.setImageResource(it) }
            detailTvName.text = data?.user?.name
            detailTvLocation.text = data?.user?.location
            detailTvTemperature.text = "${data?.user?.temperature} °C"
            detailTvTitle.text = data?.title
            detailTvContents.text = data?.contents
            detailTvPrice.text = dec.format(data?.price)
            data?.user?.profileSrc?.let { detailIvUserImage.setImageResource(it) }
            data?.user?.temperatureSrc?.let {
                if(data.user.temperature >= 36.5 && data.user.temperature < 40.5){
                    detailIvTemperature.setImageResource(it)
                } else if (data.user.temperature >= 40.5 && data.user.temperature < 50.5){
                    detailIvTemperature.setImageResource(R.drawable.ic_2)
                } else {
                    detailIvTemperature.setImageResource(R.drawable.ic_3)
                }
            }
        }

        binding.ivBack.setOnClickListener { finish() }
    }
}