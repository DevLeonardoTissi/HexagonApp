package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun HexagonAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainGraph) {
        mainNavigationGraph(navController)
    }
}