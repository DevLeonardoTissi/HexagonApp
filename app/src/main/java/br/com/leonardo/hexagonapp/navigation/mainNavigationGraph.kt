package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesScreen
import br.com.leonardo.ui.screen.HexagonScreen
import kotlinx.serialization.Serializable
import org.koin.java.KoinJavaComponent

@Serializable
object MainGraph

fun NavGraphBuilder.mainNavigationGraph(navController: NavController) {

    val screens: List<HexagonScreen> = KoinJavaComponent.getKoin().getAll<HexagonScreen>()

    navigation<MainGraph>(startDestination = ActivesProfilesScreen.HomeRoute) {
        screens.forEach { screen ->
            screen.registerScreen(this)
        }
    }
}
