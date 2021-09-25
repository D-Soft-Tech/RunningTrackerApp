package com.example.runningtrackerapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
}