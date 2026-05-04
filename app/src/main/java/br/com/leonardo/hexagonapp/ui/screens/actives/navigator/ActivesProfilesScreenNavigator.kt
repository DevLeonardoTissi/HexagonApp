package br.com.leonardo.hexagonapp.ui.screens.actives.navigator

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.ui.navigator.ScreenNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class ActivesProfilesScreenNavigator : ScreenNavigator<HomeRoute, ActivesProfilesScreen> {

    override val screen = ActivesProfilesScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module {
        return module {
            navigation<HomeRoute>{
                screen.Content()
            }
        }
    }
}