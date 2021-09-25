package com.example.runningtrackerapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "runnings_table")
data class Run(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeed: Float = 0f,
    var distance: Int = 0,
    var timeTakenInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
