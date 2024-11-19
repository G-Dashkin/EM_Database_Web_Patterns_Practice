package com.example.em_database_web_patterns_practice.presentation.Task_1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FlowerDao {
    @Query("SELECT * FROM flower_table")
    suspend fun getAllFlower(): List<Flower>

    @Insert
    suspend fun insertFlower(flower: Flower)

    @Query("DELETE FROM flower_table")
    suspend fun deleteFlowers()
}