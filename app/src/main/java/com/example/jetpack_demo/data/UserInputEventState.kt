package com.example.jetpack_demo.data

sealed class UserDataUIEvent {

    data class NameChanged(val name: String) : UserDataUIEvent()
    data class AnimalSelected(val animal: String) : UserDataUIEvent()
}