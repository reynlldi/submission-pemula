package com.example.submissionpemulaapp

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.submissionpemulaapp.databinding.ActivityDetailAnimalBinding

class DetailAnimalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.gray_dark)))

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_animal", Animal::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_animal")
        }

        if (data != null) {
            Glide.with(this)
                .load(data.photo)
                .into(binding.imageView)
            binding.animal.text = data.animal
            binding.latin.text = data.latin
            binding.description.text = data.description
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}