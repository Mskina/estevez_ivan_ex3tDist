package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    private val _list = mutableStateListOf<ShoppingProduct>()
    val list get() = _list


    fun remove(item: ShoppingProduct) {
        _list.remove(item)
    }

    fun add(item: ShoppingProduct) {
        _list.add(item)
    }

    fun engadir(productString: String) =
        if (list.none { productString == it.name })
            add(ShoppingProduct(productString))
        else false


    fun incrementarValor(
        item: ShoppingProduct
    ) =
        list.find { it.id == item.id }?.let { item ->
            item.cuentaItem++
        }

    fun decrementarValor(
        item: ShoppingProduct
    ) =
        list.find { it.id == item.id }?.let { item ->
            item.cuentaItem--
        }


}
