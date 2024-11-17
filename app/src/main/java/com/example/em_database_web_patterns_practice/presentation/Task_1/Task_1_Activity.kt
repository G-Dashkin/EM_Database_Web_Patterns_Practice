package com.example.em_database_web_patterns_practice.presentation.Task_1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.em_database_web_patterns_practice.R
import com.example.em_database_web_patterns_practice.data.database.AppDatabase
import com.example.em_database_web_patterns_practice.data.database.dao.FlowersDao

class Task_1_Activity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        db = AppDatabase.createDatabase(this)

//        Log.d("MyLog",database.flowersDao().toString())

//        val selectedProject = projectsDao.getSelectedProject(userId.toString())
    }
}