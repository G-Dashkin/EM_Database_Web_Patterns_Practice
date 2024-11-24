package com.example.em_database_web_patterns_practice.presentation.Task_1.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Bouquet
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.BouquetFlower
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Flower

@Dao
interface FlowersShopDao {

    @Query("SELECT * FROM flowers_table")
    suspend fun getAllFlowers(): List<Flower>

    @Insert
    suspend fun insertFlower(flower: Flower)

    @Update
    suspend fun updateFlower(flower: Flower)

    @Query("DELETE FROM flowers_table")
    suspend fun deleteAllFlowers()

    @Query("SELECT * FROM bouquets_table")
    suspend fun getAllBouquets(): List<Bouquet>

    @Insert
    suspend fun insertBouquet(bouquet: Bouquet)

    @Query("DELETE FROM bouquets_table")
    suspend fun deleteAllBouquets()

    @Query("SELECT * FROM bouquet_flower_table WHERE bouquetId = :bouquetId")
    suspend fun getFlowersInBouquetById(bouquetId: Int): List<BouquetFlower>

    @Query("SELECT * FROM bouquet_flower_table")
    suspend fun getAllFlowersInBouquet(): List<BouquetFlower>

    @Insert
    suspend fun insertBouquetFlower(bouquetFlower: BouquetFlower)

}