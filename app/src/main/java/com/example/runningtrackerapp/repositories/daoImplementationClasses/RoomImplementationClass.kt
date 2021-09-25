package com.example.runningtrackerapp.repositories.daoImplementationClasses

import com.example.runningtrackerapp.db.Run
import com.example.runningtrackerapp.db.RunDao
import javax.inject.Inject

class RoomImplementationClass @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRunToDB(run: Run) {
        runDao.insertRunToDB(run)
    }

    suspend fun deleteRun(run: Run) {
        runDao.deleteRun(run)
    }

    fun getAllRunsSortedByDate() =
        runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByDistanceCover() = runDao.getAllRunsSortedByDistanceCover()

    fun getAllRunsSortedByTimeTakeInMillis() = runDao.getAllRunsSortedByTimeTakeInMillis()

    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

    fun getTotalTotalCaloriesBurntSoFar() = runDao.getTotalTotalCaloriesBurntSoFar()

    fun getTotalTotalDistanceCoveredSoFar() = runDao.getTotalTotalDistanceCoveredSoFar()

    fun getTotalTotalAverageSpeedSoFar() = runDao.getTotalTotalAverageSpeedSoFar()
}
