package com.example.em_database_web_patterns_practice.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.em_database_web_patterns_practice.data.database.entities.FlowersEntity

@Dao
interface FlowersDao {

//    @Insert
//    fun insertFlower(flower: FlowersEntity)
//
//    @Query("SELECT * FROM ${FlowersEntity.FLOWER_NAME}")
//    suspend fun getAll(): List<FlowersEntity>

//        @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME} " +
//            "WHERE ${ProjectEntity.USER_ID} = :userId " +
//            "ORDER BY ${ProjectEntity.ID} ASC")
//    suspend fun getAllProjectsOfUser(userId: String): List<ProjectEntity>

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(newProject: ProjectEntity)
//
//    @Query("UPDATE ${ProjectEntity.TABLE_NAME} SET ${ProjectEntity.SELECTED_PROJECT} = 0 " +
//            "WHERE ${ProjectEntity.USER_ID} = :userId")
//    suspend fun resectSelectedProjects(userId: String)
//
//    @Query("DELETE FROM ${ProjectEntity.TABLE_NAME} " +
//            "WHERE ${ProjectEntity.TABLE_NAME}.${ProjectEntity.ID} = :projectId")
//    suspend fun delete(projectId: String)
//
//    @Query("UPDATE projects SET ${ProjectEntity.PROJECT_NAME} = :editName " +
//            "WHERE ${ProjectEntity.ID} = :projectId")
//    suspend fun edit(projectId: String, editName: String)
//
//    @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME} " +
//            "WHERE ${ProjectEntity.USER_ID} = :userId " +
//            "ORDER BY ${ProjectEntity.ID} ASC LIMIT 1")
//    suspend fun getLastProjectId(userId: String): ProjectEntity
//
//    @Query("UPDATE ${ProjectEntity.TABLE_NAME} SET ${ProjectEntity.SELECTED_PROJECT} = " +
//            "CASE WHEN ${ProjectEntity.ID} = :projectId THEN 1 ELSE 0 END")
//    suspend fun selectProject(projectId: String)
//
//    @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME} " +
//            "WHERE ${ProjectEntity.USER_ID} = :userId " +
//            "AND ${ProjectEntity.SELECTED_PROJECT} = '1'")
//    suspend fun getSelectedProject(userId: String): ProjectEntity
//
//    @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME} " +
//            "WHERE ${ProjectEntity.USER_ID} = :userId " +
//            "ORDER BY ${ProjectEntity.ID} ASC")
//    suspend fun getAllProjectsOfUser(userId: String): List<ProjectEntity>
}