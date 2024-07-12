package com.example.jetpack_demo.ui.screens

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpack_demo.data.UserDataUIEvent
import com.example.jetpack_demo.data.UserInputState

class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputState())

    fun onEvent(event: UserDataUIEvent) {
        when (event) {
            is UserDataUIEvent.NameChanged -> {

                uiState.value = uiState.value.copy(name = event.name)

                Log.d(TAG, "Name changed: ${event.name}")

            }

            is UserDataUIEvent.AnimalSelected -> {

                uiState.value = uiState.value.copy(animalSelected = event.animal)

                Log.d(TAG, "Animal selected: ${event.animal}")
            }

        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.name.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }


}


