package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation

import br.com.leonardo.appcore.presentation.navigator.ScreenNavigator
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation.route.InactiveRoute
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class InactivesProfilesScreenNavigator : ScreenNavigator<InactiveRoute, InactivesProfilesScreen> {
    override val screen = InactivesProfilesScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module =
        module {
            navigation<InactiveRoute> { arguments ->
                screen.Content(arguments = arguments)
            }
        }
}
