package com.example.estevez_ivan_ex3tDist.screens.ej02

import java.util.concurrent.atomic.AtomicInteger
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ShoppingProduct(
    val name: String,
    val initialCuenta: Int = 0,
) {
    val id: Int = identifier.incrementAndGet()
    var cuentaItem: Int by mutableStateOf(initialCuenta)

    companion object { // (1)
        private val identifier: AtomicInteger = AtomicInteger(0)  // (2)
    }
}

/**
 * (1) Kotlin utiliza companion objects para encapsular miembros de clase (lo que en java serían static).
 * En este caso. El indice de identificadores es común a todos los objetos de la clase
 *
 * (2) Variable autoincrementada
 * https://stackoverflow.com/questions/24305830/java-auto-increment-id
 * https://stackoverflow.com/questions/70309293/each-instance-of-class-worker-should-have-an-own-id-starting-at-1-and-get-inc
 *
 */
