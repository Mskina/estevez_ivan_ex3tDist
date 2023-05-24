package com.example.estevez_ivan_ex3tDist.screens.ej02
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.estevez_ivan_ex3tDist.R

@Composable
fun Ej02Screen() {

    val viewModel: ShoppingListViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.title)) },
                actions = {
                    Text(
                        text = stringResource(R.string.global) + viewModel.list.size,
                    modifier = Modifier.padding(end = 10.dp))

                },
            )
        }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            AddBlock { viewModel.add(ShoppingProduct(it)) }
            ShoppingList(
                list = viewModel.list,
                onCloseItem = { viewModel.remove(it) },
                onIncrementar = {viewModel.incrementarValor(it)},
                onDecrementar = {viewModel.decrementarValor(it)},
            )

        }


    }
}

