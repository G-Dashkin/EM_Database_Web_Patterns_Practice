package com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets_table")
data class Bouquet(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "bouquet_name") val name: String
//    @ColumnInfo(name = "design") val design: String // Доп. поле для миграции из задания 2
)