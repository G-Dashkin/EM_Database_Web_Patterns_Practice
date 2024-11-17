package com.example.em_database_web_patterns_practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.em_database_web_patterns_practice.databinding.ActivityMainBinding
import com.example.em_database_web_patterns_practice.presentation.Task_1.Task_1_Activity
import com.example.em_database_web_patterns_practice.presentation.Task_2.Task_2_Activity
import com.example.em_database_web_patterns_practice.presentation.Task_3.Task_3_Activity
import com.example.em_database_web_patterns_practice.presentation.Task_4.Task_4_Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnTask1.setOnClickListener {
                startActivity(Intent(this@MainActivity, Task_1_Activity::class.java))
            }
            btnTask2.setOnClickListener {
                startActivity(Intent(this@MainActivity, Task_2_Activity::class.java))
            }
            btnTask3.setOnClickListener {
                startActivity(Intent(this@MainActivity, Task_3_Activity::class.java))
            }
            btnTask4.setOnClickListener {
                startActivity(Intent(this@MainActivity, Task_4_Activity::class.java))
            }
        }
    }
}