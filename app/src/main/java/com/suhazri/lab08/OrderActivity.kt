package com.suhazri.lab08

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.suhazri.lab08.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneNumberTextView.text = intent.getStringExtra("phoneNumber")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.dateTextView.text = intent.getStringExtra("date")
        binding.timeTextView.text = intent.getStringExtra("time")

        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            binding.rating.text = rating.toString()
        }

        binding.sendButton.setOnClickListener {
            Snackbar.make(view, "Thank you for your feedback!", Snackbar.LENGTH_LONG)
                .setAction("OK"){}.show()
        }
    }

}