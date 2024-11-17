package com.example.em_database_web_patterns_practice.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BouquetEntity.TABLE_NAME)
data class BouquetEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "flower_name")
    val flower: String
) {
    companion object {
        const val TABLE_NAME = "flowers"
        const val ID = "id"
        const val FLOWER_NAME = "flower_name"
    }
}