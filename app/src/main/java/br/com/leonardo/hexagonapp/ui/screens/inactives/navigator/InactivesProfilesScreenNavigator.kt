package br.com.leonardo.hexagonapp.ui.screens.inactives.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.ui.navigator.ScreenNavigator

class InactivesProfilesScreenNavigator : ScreenNavigator<InactiveRoute> {

    override val screen = InactivesProfilesScreen()

    override val destination = InactiveRoute

    override fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<InactiveRoute> {
            screen.Content()
        }
    }

}