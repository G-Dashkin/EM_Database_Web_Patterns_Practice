package com.example.em_database_web_patterns_practice.presentation.Task_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.em_database_web_patterns_practice.R
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Flower
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.FlowerShopDatabase
import kotlinx.coroutines.launch

class Task_1_Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val database = FlowerShopDatabase.getDatabase(this)
        val wordDao = database.flowerDao()
        lifecycleScope.launch {
            // add flowers
            wordDao.insertFlower(Flower(1,"Red Rose"))
            wordDao.insertFlower(Flower(2,"White Rose"))
            wordDao.insertFlower(Flower(3,"Orchid"))
            wordDao.insertFlower(Flower(4,"Chrysanthemum"))
            wordDao.insertFlower(Flower(5,"Iris"))
            wordDao.insertFlower(Flower(6,"Hydrangea"))
            wordDao.insertFlower(Flower(7,"Bougainvillea"))
            wordDao.insertFlower(Flower(8,"Dahlia"))
            wordDao.insertFlower(Flower(9,"Orchid"))
            wordDao.insertFlower(Flower(10,"Sunflower"))

            val flowers = wordDao.getAllFlower()
//            wordDao.deleteFlowers()
            Log.d("MyLog", flowers.toString())
        }
    }
}