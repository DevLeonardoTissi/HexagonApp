package br.com.leonardo.hexagonapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

internal const val mainGraphRoute = "main"

fun NavGraphBuilder.mainNavigationGraph(navController: NavController) {
    navigation(startDestination = homeRoute, route = mainGraphRoute) {
        homeScreen(navController)
        formScreen(navController)
        inactiveScreen(navController)
    }
}