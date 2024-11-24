package com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers_table")
data class Flower(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "flower_name") val flower: String,
    @ColumnInfo(name = "flower_count") var count: Int
//    @ColumnInfo(name = "country") val country: String // Доп. поле для миграции из задания 2
)