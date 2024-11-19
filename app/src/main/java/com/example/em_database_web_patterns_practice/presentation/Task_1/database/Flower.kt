package com.example.em_database_web_patterns_practice.presentation.Task_1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flower_table")
data class Flower(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "flower") val word: String
)