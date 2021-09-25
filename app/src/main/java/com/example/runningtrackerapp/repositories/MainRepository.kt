package com.example.runningtrackerapp.repositories

import com.example.runningtrackerapp.repositories.daoImplementationClasses.RoomImplementationClass
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(
    localDataSource: RoomImplementationClass
) {
    val local = localDataSource
}
