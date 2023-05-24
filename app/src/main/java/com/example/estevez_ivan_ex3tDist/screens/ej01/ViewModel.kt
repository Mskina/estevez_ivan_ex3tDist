package com.example.estevez_ivan_ex3tDist.screens.ej01

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val _items = mutableStateListOf<ShoppingInventory>()
    val items: List<ShoppingInventory>
        get() = _items

    fun remove() {
        _items.removeAll(items)
    }

    fun add(item: ShoppingInventory) {
        _items.add(item)
    }

    fun engadir(num: Int) {
        repeat(num) {
            this.add(ShoppingInventory())
        }
    }

    fun incrementarValor(
        item: ShoppingInventory
    ) =
        //items.find { it.id == item.id }?.let { item ->
        item.cuentaItem++
    // }

    fun decrementarValor(
        item: ShoppingInventory
    ) =
        items.find { it.id == item.id }?.let { item ->
            item.cuentaItem--
        }

}

//private fun getItems() = List(0) { i -> ShoppingInventory() }

