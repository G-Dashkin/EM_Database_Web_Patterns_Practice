package com.example.em_database_web_patterns_practice.presentation.Task_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Dao.FlowersShopDao
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Bouquet
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.BouquetFlower
import com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities.Flower

@Database(entities = [Flower::class, Bouquet::class, BouquetFlower::class], version = 1, exportSchema = false)
abstract class FlowersShopDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowersShopDao

    companion object {
        @Volatile
        private var INSTANCE: FlowersShopDatabase? = null

        fun getDatabase(context: Context): FlowersShopDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlowersShopDatabase::class.java,
                    "flowers_shop_database"
                )
//                    .addMigrations(MigrationFlowersShopDatabase.MIGRATION_1_2) // вызов миграции для второго задания
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}