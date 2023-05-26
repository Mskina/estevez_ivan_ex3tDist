package com.example.estevez_ivan_ex3tDist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estevez_ivan_ex3tDist.screens.*
import com.example.estevez_ivan_ex3tDist.screens.ej01.ui.elements.Ej01Screen
import com.example.estevez_ivan_ex3tDist.screens.ej02.Ej02Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MainScreen(navController) }
        composable(route = Screens.Ejercicio01.route) { Ej01Screen() }
        composable(route = Screens.Ejercicio02.route) { Ej02Screen() }


    }
}

