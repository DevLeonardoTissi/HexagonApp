package br.com.leonardo.ui

import androidx.compose.foundation.gestures.forEach
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

//class HexagonNavigator {
//        // Rota inicial centralizada
//        val startDestination = MainGraph
//
//        fun registerAppGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
//            navGraphBuilder.navigation<MainGraph>(startDestination = ActivesProfilesScreen.HomeRoute) {
//                screens.forEach { screen ->
//                    screen.registerScreen(this)
//                }
//            }
//        }
//    }
//
//
//}