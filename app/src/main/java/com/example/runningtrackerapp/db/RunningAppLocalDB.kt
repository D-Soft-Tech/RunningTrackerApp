package com.example.runningtrackerapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1, exportSchema = false)
@TypeConverters(TypeConvertesr::class)
abstract class RunningAppLocalDB : RoomDatabase() {

    abstract fun getDao(): RunDao
}
