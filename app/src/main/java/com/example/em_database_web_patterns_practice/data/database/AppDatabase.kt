package com.example.em_database_web_patterns_practice.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.em_database_web_patterns_practice.data.database.dao.FlowersDao
import com.example.em_database_web_patterns_practice.data.database.entities.FlowersEntity

private const val DATABASE_VERSION = 1
private const val DATABASE_NAME = "flowers_db"

@Database(entities = [FlowersEntity::class], version = DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract fun flowersDao(): FlowersDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        fun createDatabase(context: Context): AppDatabase {
            return instance?: synchronized(LOCK) {
                Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = DATABASE_NAME
                )
//                    .addCallback(object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
////                        val flowersDao = instance!!.flowersDao()
////                        val flowers = listOf(
////                            FlowersEntity(0,"flower_1"),
////                            FlowersEntity(1,"flower_2")
////                        )
////                        Thread {
////                            flowers.forEach { flowersDao.insertFlower(it) }
////                        }.start()
//                    }
//                })
                    .build()
            }
        }
    }
}