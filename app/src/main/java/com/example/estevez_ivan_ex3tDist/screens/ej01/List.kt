package com.example.estevez_ivan_ex3tDist.screens.ej01

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun List(
    list: List<ShoppingInventory>,
    modifier: Modifier = Modifier,
    onIncrementar: (ShoppingInventory) -> Unit,
    onDecrementar: (ShoppingInventory) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = list,
            key = { item -> item.id }
        ) { item ->
            Item(
                itemContador = item.cuentaItem,
                onIncrementar = { onIncrementar(item) },
                onDecrementar = { onDecrementar(item) },
            )
        }
        item { Spacer(modifier = Modifier.padding(30.dp)) } // #2
    }
}

/**
 * #1
 * Con animateItemPlacement() se logra que al añadir/eliminar elementos, se realice una animación.
 * El modifier DEBE ser nuevo para esto o arrastraría las modificaciones previas.
 * Fuente: https://fvilarino.medium.com/exploring-jetpack-compose-lazylist-animations-a3f97c91c2dd
 *
 * #2
 * Con este espacio me aseguro que quede un hueco bajo la última tarjeta, de forma
 * que el FAB no tape la X de eliminar.
 */

