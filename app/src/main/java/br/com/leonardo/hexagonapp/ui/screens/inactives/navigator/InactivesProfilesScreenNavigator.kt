package br.com.leonardo.hexagonapp.ui.screens.inactives.navigator

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.ui.navigator.ScreenNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class InactivesProfilesScreenNavigator : ScreenNavigator<InactiveRoute, InactivesProfilesScreen> {

    override val screen = InactivesProfilesScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module = module {
        navigation<InactiveRoute> { arguments ->
            screen.Content(arguments = arguments)
        }
    }
}