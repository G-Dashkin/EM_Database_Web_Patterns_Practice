package com.example.em_database_web_patterns_practice.presentation.Task_2

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Класс с описанием миграции (нужно не забыть поменять версию базы при миграции)
class MigrationFlowersShopDatabase {
    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Bouquet ADD COLUMN design TEXT")
                database.execSQL("ALTER TABLE Flower ADD COLUMN country TEXT")
            }
        }
    }
}