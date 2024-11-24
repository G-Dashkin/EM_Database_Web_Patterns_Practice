package com.example.em_database_web_patterns_practice.presentation.Task_1.database.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "bouquet_flower_table",
    foreignKeys = [
        ForeignKey(entity = Bouquet::class, parentColumns = ["id"], childColumns = ["bouquetId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Flower::class, parentColumns = ["id"], childColumns = ["flowerId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class BouquetFlower(
    @PrimaryKey val id: Int,
    val bouquetId: Int,
    val flowerId: Int,
    val quantity: Int
)