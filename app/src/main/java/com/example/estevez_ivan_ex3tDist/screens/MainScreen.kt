package com.example.estevez_ivan_ex3tDist.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.estevez_ivan_ex3tDist.R
import com.example.estevez_ivan_ex3tDist.navigation.Screens

@Composable
fun MainScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ejercicio01.route) }) {
            Text(text = stringResource(R.string.ej01_button))
        }
        Button(onClick = { navController.navigate(route = Screens.Ejercicio02.route) }) {
            Text(text = stringResource(R.string.ej02_button))
        }
    }

}