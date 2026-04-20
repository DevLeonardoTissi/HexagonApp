package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.navigator.NavEvent
import org.koin.compose.koinInject

@Composable
fun HexagonAppNavHost(navController: NavHostController) {

    val navigationManager: HexagonNavigator = koinInject()

    LaunchedEffect(navController) {
        navigationManager.navigationEvents.collect { event ->
            when (event) {
                is NavEvent.To -> navController.navigate(event.route, event.navOptions)
                is NavEvent.Back -> navController.popBackStack()
                is NavEvent.PopUp -> navController.navigateUp()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = navigationManager.startDestination
    ) {
        navigationManager.registerAppGraph(this)
    }
}