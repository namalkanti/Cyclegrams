package com.mf.cyclegrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.mf.cyclegrams.databinding.ActivityMainBinding

import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val calendar = binding.calendarView
        val todayBuilder = Calendar.Builder()
        todayBuilder.setInstant(calendar.date)
        var selectedDate = todayBuilder.build()

        calendar.setOnDateChangeListener{_, year, month, dayOfMonth ->
            val builder = Calendar.Builder()
            builder.setDate(year, month, dayOfMonth)
            selectedDate = builder.build()
        }

        //Button Setup
        val alpha: Button = binding.alpha
        alpha.setOnClickListener {
            Toast.makeText(this,
                selectedDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()),
                Toast.LENGTH_SHORT).show()
        }
        val bravo: Button = binding.bravo
        bravo.setOnClickListener {
            Toast.makeText(this,
                selectedDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()),
                Toast.LENGTH_SHORT).show()
        }
    }
}
