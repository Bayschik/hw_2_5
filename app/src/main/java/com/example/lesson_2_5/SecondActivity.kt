package com.example.lesson_2_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lesson_2_5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra("result")
        binding.tvResult.text = intent

        Glide.with(binding.loveImage).load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSTELcBYiBtHk-wR6bYGyPdcP26ARO_yR-LjDR3pnQaZf4gRQ5b").into(binding.loveImage)
    }
}