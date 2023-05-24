package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onCloseItem: (ShoppingProduct) -> Unit,
    onIncrementar: (ShoppingProduct) -> Unit,
    onDecrementar: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { it.id })
        { element ->
            ShoppingListItem(
                elementName = element.name,
                elementContador = element.cuentaItem,
                onClose = { onCloseItem(element) },
                onIncrementar = { onIncrementar(element) },
                onDecrementar = { onDecrementar(element) },
            )
        }
    }
}
