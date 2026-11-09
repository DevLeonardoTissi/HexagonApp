package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.navigation

import br.com.leonardo.appcore.presentation.navigator.ScreenNavigator
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.navigation.route.DevProfileScreenRoute
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class DevProfileScreenNavigator : ScreenNavigator<DevProfileScreenRoute, DevProfileScreen> {
    override val screen = DevProfileScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module =
        module {
            navigation<DevProfileScreenRoute> { arguments ->
                screen.Content(arguments = arguments)
            }
        }
}
