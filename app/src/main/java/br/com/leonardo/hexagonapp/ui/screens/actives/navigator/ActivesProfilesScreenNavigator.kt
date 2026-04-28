package br.com.leonardo.hexagonapp.ui.screens.actives.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.ui.navigator.ScreenNavigator

class ActivesProfilesScreenNavigator : ScreenNavigator<HomeRoute> {

    override val screen = ActivesProfilesScreen()

    override val destination = HomeRoute

    override fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<HomeRoute> {
            screen.Content()
        }
    }

}