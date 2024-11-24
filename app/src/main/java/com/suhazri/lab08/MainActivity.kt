package com.suhazri.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.suhazri.lab08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pizzaSize = arrayListOf("Small", "Medium", "Large", "Extra Large")

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.size.text = pizzaSize[p1]
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.dateButton.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                {datePicker, year, month, dayOfMonth ->
                    binding.date.text = "$dayOfMonth/${month + 1}/$year"
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        binding.timeButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                {timePicker, hourOfDay, minute ->
                    binding.time.text = String.format("%02d:%02d", hourOfDay, minute)
                },
                hour,
                minute,
                true // Set to true for 24-hour format, false for 12-hour format
            )
            timePickerDialog.show()
        }

        binding.scheduleButton.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)

            intent.putExtra("name", binding.name.text.toString())
            intent.putExtra("phoneNumber", binding.phoneNumber.text.toString())
            intent.putExtra("size", binding.size.text.toString())
            intent.putExtra("date", binding.date.text.toString())
            intent.putExtra("time", binding.time.text.toString())

            startActivity(intent)
        }

    }
}