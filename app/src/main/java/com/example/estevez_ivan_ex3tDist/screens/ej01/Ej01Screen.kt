package com.example.estevez_ivan_ex3tDist.screens.ej01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.estevez_ivan_ex3tDist.R

@Preview
@Composable
fun Ej01Screen() {
    val viewModel: ViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title)) },
                actions = {
                    if (viewModel.items.isNotEmpty()) {
                        IconButton(
                            onClick = { viewModel.remove() }
                        ) {
                            Icon(Icons.Filled.Refresh, stringResource(R.string.removeAll))
                        }

                    }

                })
        },
    ) {

        if (viewModel.items.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                var input by rememberSaveable { mutableStateOf("") }

                TextField(
                    value = input,
                    onValueChange = { input = it },
                    //placeholder = stringResource(R.string.numeroContadores),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(onClick = {
                    viewModel.engadir(input.toIntOrNull() ?: 0)
                }) {
                    Text(text = stringResource(R.string.show))
                }
            }
        }

        if (viewModel.items.isNotEmpty()) {
            List(
                list = viewModel.items,
                modifier = Modifier.padding(paddingValues = it),
                onIncrementar = { viewModel.incrementarValor(it) },
                onDecrementar = { viewModel.decrementarValor(it) },
            )
        }
    }
}


