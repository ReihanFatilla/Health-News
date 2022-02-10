package com.reihan.androidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reihan.androidpemula.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val NEWS_TITLE = "title"
        const val NEWS_AUTHOR = "author"
        const val NEWS_DATE = "date"
        const val NEWS_DESC = "desc"
        const val NEWS_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra(NEWS_TITLE)
        val author = intent.getStringExtra(NEWS_AUTHOR)
        val date = intent.getStringExtra(NEWS_DATE)
        val desc = intent.getStringExtra(NEWS_DESC)
        val image = intent.getIntExtra(NEWS_IMAGE, 0)

        binding.apply {
            tvTitle.text = title
            tvAuthor.text = author
            tvDate.text = date
            tvDesc.text = desc
            imgNews.setImageResource(image)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}