package br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.route.DevProfileScreenRoute
import br.com.leonardo.ui.navigator.ScreenNavigator

class DevProfileScreenNavigator : ScreenNavigator<DevProfileScreenRoute> {

    override val screen = DevProfileScreen()

    override val destination = DevProfileScreenRoute

    override fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<DevProfileScreenRoute> {
            screen.Content()
        }
    }

}