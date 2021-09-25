package com.example.runningtrackerapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRunToDB(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM runnings_table ORDER BY timeStamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM runnings_table ORDER BY avgSpeed DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM runnings_table ORDER BY distance DESC")
    fun getAllRunsSortedByDistanceCover(): LiveData<List<Run>>

    @Query("SELECT * FROM runnings_table ORDER BY timeTakenInMillis DESC")
    fun getAllRunsSortedByTimeTakeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM runnings_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT SUM(timeTakenInMillis) FROM runnings_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM runnings_table")
    fun getTotalTotalCaloriesBurntSoFar(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM runnings_table")
    fun getTotalTotalDistanceCoveredSoFar(): LiveData<Int>

    @Query("SELECT AVG(avgSpeed) FROM runnings_table")
    fun getTotalTotalAverageSpeedSoFar(): LiveData<Float>
}
