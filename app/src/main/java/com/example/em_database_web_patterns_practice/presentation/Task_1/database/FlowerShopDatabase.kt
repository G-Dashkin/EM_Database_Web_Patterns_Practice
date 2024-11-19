package com.example.em_database_web_patterns_practice.presentation.Task_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Flower::class], version = 1, exportSchema = false)
abstract class FlowerShopDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao

    companion object {
        @Volatile
        private var INSTANCE: FlowerShopDatabase? = null

        fun getDatabase(context: Context): FlowerShopDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlowerShopDatabase::class.java,
                    "flower_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}