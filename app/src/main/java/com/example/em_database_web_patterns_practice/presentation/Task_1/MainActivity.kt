package com.example.em_database_web_patterns_practice.presentation.Task_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.em_database_web_patterns_practice.R
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Flower
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Dao.FlowersShopDao
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Bouquet
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.BouquetFlower
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.FlowersShopDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FlowersShopDatabase.getDatabase(this)
        val flowerDao = database.flowerDao()
        lifecycleScope.launch {

            // 1) adding flowers to database and count
            Log.d("MyLog", "-------------------------------------------------------------")
            addFlowers(flowerDao)
            flowerDao.getAllFlowers().forEach { Log.d("MyLog", it.toString()) }
            //--------------------------------------------------------------------------------------

            // 2) creating bouquets and count
            Log.d("MyLog", "-------------------------------------------------------------")
            createBouquets(flowerDao)
            flowerDao.getAllBouquets().forEach { Log.d("MyLog", it.toString()) }
            //--------------------------------------------------------------------------------------

            // 3) creating relationships between bouquets and flowers
            Log.d("MyLog", "-------------------------------------------------------------")
            createBouquetFlowersRelationships(flowerDao)
            flowerDao.getAllFlowersInBouquet().forEach { Log.d("MyLog", it.toString()) }
            //-------------------------------------------------------------------------------------

            // 4) Buy bouquet with flowers
            buyBouquet(flowerDao,1)
            buyBouquet(flowerDao,2)
            //--------------------------------------------------------------------------------------

            // 5) Counting flowers and bouquets after buy
            Log.d("MyLog", "-------------------------------------------------------------")
            Log.d("MyLog", "-------------------------------------------------------------")
            Log.d("MyLog", "-------------------------------------------------------------")
            Log.d("MyLog", "After Buy Bouquet -------------------------------------------")
            flowerDao.getAllFlowers().forEach { Log.d("MyLog", it.toString()) }
            Log.d("MyLog", "-------------------------------------------------------------")
            flowerDao.getAllBouquets().forEach { Log.d("MyLog", it.toString()) }
            Log.d("MyLog", "-------------------------------------------------------------")
            flowerDao.getAllFlowersInBouquet().forEach { Log.d("MyLog", it.toString()) }
            //--------------------------------------------------------------------------------------
        }
    }


    private suspend fun addFlowers(flowerDao: FlowersShopDao){
        flowerDao.deleteAllFlowers()
        flowerDao.insertFlower(Flower(id = 1, flower = "Red Rose", count = 35))
        flowerDao.insertFlower(Flower(id = 2, flower = "White Rose", count = 20))
        flowerDao.insertFlower(Flower(id = 3, flower = "Orchid", count = 30))
        flowerDao.insertFlower(Flower(id = 4, flower = "Chrysanthemum", count = 35))
        flowerDao.insertFlower(Flower(id = 5, flower = "Iris", count = 10))
        flowerDao.insertFlower(Flower(id = 6, flower = "Hydrangea", count = 15))
        flowerDao.insertFlower(Flower(id = 7, flower = "Bougainvillea", count = 35))
        flowerDao.insertFlower(Flower(id = 8, flower = "Dahlia", count = 25))
        flowerDao.insertFlower(Flower(id = 9, flower = "Orchid", count = 30))
        flowerDao.insertFlower(Flower(id = 10, flower = "Sunflower", count = 15))
    }

    private suspend fun createBouquets(flowerDao: FlowersShopDao){
        flowerDao.deleteAllBouquets()
        flowerDao.insertBouquet(Bouquet(id = 1, name = "Bouquet_one"))
        flowerDao.insertBouquet(Bouquet(id = 2, name = "Bouquet_Two"))
        flowerDao.insertBouquet(Bouquet(id = 3, name = "Bouquet_Three"))
    }

    private suspend fun createBouquetFlowersRelationships(flowerDao: FlowersShopDao){
        flowerDao.insertBouquetFlower(BouquetFlower(id = 1, bouquetId = 1, flowerId = 1, quantity = 5))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 2, bouquetId = 1, flowerId = 2, quantity = 10))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 3, bouquetId = 1, flowerId = 3, quantity = 4))

        flowerDao.insertBouquetFlower(BouquetFlower(id = 4, bouquetId = 2, flowerId = 6, quantity = 10))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 5, bouquetId = 2, flowerId = 4, quantity = 15))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 6, bouquetId = 2, flowerId = 7, quantity = 10))

        flowerDao.insertBouquetFlower(BouquetFlower(id = 7, bouquetId = 3, flowerId = 5, quantity = 15))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 8, bouquetId = 3, flowerId = 8, quantity = 8))
        flowerDao.insertBouquetFlower(BouquetFlower(id = 9, bouquetId = 3, flowerId = 2, quantity = 5))
    }

    private suspend fun buyBouquet(flowerDao: FlowersShopDao, bouquetId: Int) {
        val bouquetFlowers = flowerDao.getFlowersInBouquetById(bouquetId)
        bouquetFlowers.forEach { bf ->
            val flower = flowerDao.getAllFlowers().find { it.id == bf.flowerId }
            if (flower != null) {
                val newQuantity = flower.count - bf.quantity
                if (newQuantity >= 0) {
                    flower.count = newQuantity
                    flowerDao.updateFlower(flower)
                }
            }
        }
    }



}