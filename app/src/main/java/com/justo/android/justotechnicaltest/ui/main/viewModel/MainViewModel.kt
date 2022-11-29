package com.justo.android.justotechnicaltest.ui.main.viewModel


import androidx.lifecycle.ViewModel
import com.justo.android.justotechnicaltest.data.repository.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: RandomUserRepository) :
    ViewModel() {
    var user = userRepository.getRandomUser()

    fun retrieveNewUsers() {
        user = userRepository.getRandomUser()
    }
}