package com.reihan.androidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.reihan.androidpemula.Kotlin.DataNews
import com.reihan.androidpemula.Kotlin.NewsAdapter
import com.reihan.androidpemula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.apply{
            rvNews.layoutManager = LinearLayoutManager(this@MainActivity)
            rvNews.adapter = NewsAdapter(DataNews.dataNews)

            fabAbout.setOnClickListener{
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
    }
}