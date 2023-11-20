package com.example.lesson_2_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lesson_2_5.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.loveImage).load("https://www.logos.com/grow/wp-content/uploads/2023/02/WxW-Love.png").into(binding.loveImage)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnCalculate.setOnClickListener{
                RetrofitService.api.getLove(etFirst.text.toString(), etSecond.text.toString())
                    .enqueue(object :Callback<LoveModel>{
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            val intent = Intent(this@MainActivity, SecondActivity::class.java)
                            intent.putExtra("result", response.body()?.percentage.toString())
                            startActivity(intent)
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            tvResult.text = t.message
                        }

                    })
            }
        }
    }
}