package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation

import br.com.leonardo.appcore.presentation.navigator.ScreenNavigator
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.route.HomeRoute
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class ActivesProfilesScreenNavigator : ScreenNavigator<HomeRoute, ActivesProfilesScreen> {
    override val screen = ActivesProfilesScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module =
        module {
            navigation<HomeRoute> { arguments ->
                screen.Content(arguments = arguments)
            }
        }
}
