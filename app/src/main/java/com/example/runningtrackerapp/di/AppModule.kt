package com.example.runningtrackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.runningtrackerapp.db.RunningAppLocalDB
import com.example.runningtrackerapp.utils.AppConstants.RUNNING_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRunningDB(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RunningAppLocalDB::class.java,
        RUNNING_DB_NAME
    ).build()

    @Singleton
    @Provides
    fun providesRunRoomDao(db: RunningAppLocalDB) = db.getDao()
}




