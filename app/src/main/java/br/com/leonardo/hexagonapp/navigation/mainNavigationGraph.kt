package br.com.leonardo.hexagonapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object MainGraph

fun NavGraphBuilder.mainNavigationGraph(navController: NavController) {
    navigation<MainGraph>(startDestination = HomeRoute) {
        homeScreen(navController)
        formScreen(navController)
        inactiveScreen(navController)
        devProfileScreen()
    }
}