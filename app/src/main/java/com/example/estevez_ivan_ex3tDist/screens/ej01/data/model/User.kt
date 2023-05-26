package com.example.estevez_ivan_ex3tDist.screens.ej01.data.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

class User(
    val name: String,
    val email: String,
    val pwd: String,
    initialChecked: Boolean = false
) {
    val id: Int = idUser.incrementAndGet()
    var checked: Boolean by mutableStateOf(initialChecked)

    companion object {
        private val idUser: AtomicInteger = AtomicInteger(0)
    }
}