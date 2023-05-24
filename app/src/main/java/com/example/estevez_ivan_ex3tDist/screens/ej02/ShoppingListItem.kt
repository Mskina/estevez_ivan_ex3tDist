package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estevez_ivan_ex3tDist.R

@Composable
fun ShoppingListItem(
    elementName: String,
    elementContador: Int,
    onClose: () -> Unit,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 3.dp,
    ) {
        Row(
            modifier.background(MaterialTheme.colors.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column() {
                Text(
                    text = elementName,
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth(0.3f)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column() {
                Text(
                    text = elementContador.toString(),
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth(0.2f)
                )
            }

            Column() {
                Row() {
                    IconButton(onClick = onIncrementar) {
                        Icon(
                            Icons.Filled.KeyboardArrowUp,
                            tint = Color.White,
                            contentDescription = stringResource(R.string.incremento)
                        )
                    }
                }
                Row() {
                    IconButton(onClick = onDecrementar) {
                        Icon(
                            Icons.Filled.KeyboardArrowDown,
                            tint = Color.White,
                            contentDescription = stringResource(R.string.decremento)
                        )
                    }
                }
            }

            IconButton(onClick = onClose) {
                Icon(
                    Icons.Filled.Close,
                    tint = Color.White,
                    contentDescription = stringResource(R.string.close)
                )
            }
        }

    }
}
