package com.example.em_database_web_patterns_practice.presentation.Task_1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets_table")
data class Bouquets (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "bouquet_id") val word: Int,
    @ColumnInfo(name = "flower_name") val flower: String,
    @ColumnInfo(name = "flower_count") val count: Int,
)