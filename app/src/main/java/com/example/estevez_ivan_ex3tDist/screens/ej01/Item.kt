package com.example.estevez_ivan_ex3tDist.screens.ej01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Item(
    itemContador: Int,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier
            .padding(16.dp, 6.dp, 16.dp, 6.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onIncrementar,
            ) {
                Text("Incrementar")
            }

            Text(
                text = itemContador.toString()
            )

            Button(
                enabled = (itemContador >=1),
                onClick = onDecrementar,

            ) {
                Text("Decrementar")
            }
        }
    }

}