package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.estevez_ivan_ex3tDist.R
import com.example.estevez_ivan_ex3tDist.screens.ej01.ui.state.ViewModel

@Composable
fun Ej02Screen() {
    val vm: ViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.listado_de_clientes)) },
            )
        },
        bottomBar = {
            BottomAppBar(
            ) {/* Condición para que se muestre: que haya 1 o más elementos marcados
                if (true) {
                    IconButton(
                        onClick = { /**/ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Filled.Delete, stringResource(R.string.borrar))
                    }
                }*/
            }
        }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            UserList(
                list = vm.items,
                onCheckedItem = { item, checked ->
                    vm.changeItemChecked(item, checked)
                },
                onCloseItem = { vm.remove(it) },
            )

        }


    }
}

