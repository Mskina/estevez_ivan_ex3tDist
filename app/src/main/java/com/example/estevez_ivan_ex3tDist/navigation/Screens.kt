package com.example.estevez_ivan_ex3tDist.navigation

sealed class Screens(val route: String){
    object MainScreen: Screens("initial_screen")
    object Ejercicio01: Screens("ej01")
    object Ejercicio02: Screens("ej02")

}
