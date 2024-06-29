package com.myapp.dreamydrakor

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataDrama = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Drama>("key_drama", Drama::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Drama>("key_drama")
        }

        val tvDetailName = findViewById<TextView>(R.id.drama_name)
        val tvDetailDescription = findViewById<TextView>(R.id.drama_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.drama_image)
        val btnShare = findViewById<Button>(R.id.action_share)

        dataDrama?.let {
            tvDetailName.text = it.title
            tvDetailDescription.text = it.description
            ivDetailPhoto.setImageResource(it.dramaImage)
        }

        btnShare.setOnClickListener {
            Toast.makeText(this, "Anda membagikan artikel ini", Toast.LENGTH_SHORT).show()
        }
    }
}