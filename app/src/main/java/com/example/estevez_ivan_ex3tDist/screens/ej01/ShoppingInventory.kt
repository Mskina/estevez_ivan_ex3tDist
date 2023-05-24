package com.example.estevez_ivan_ex3tDist.screens.ej01

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

// Gardamos os elementos
data class ShoppingInventory(
    val initialCuenta: Int = 0,
) {
    val id: Int = idProducto.incrementAndGet()
    var cuentaItem: Int by mutableStateOf(initialCuenta)

    companion object { // (1)
        private val idProducto: AtomicInteger = AtomicInteger(0)  // (2)
    }
}

