package br.com.leonardo.hexagonapp.di.modules

import br.com.leonardo.appcore.presentation.navigator.HexagonNavigator
import br.com.leonardo.hexagonapp.ui.screens.actives.lib.ActivesProfilesScreenDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.route.HomeRoute
import br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.DevProfileScreenDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.form.lib.PersonalProfileFormScreenDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.inactives.lib.InactivesProfilesScreenDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.main.lib.MainScreenDiLibrary
import org.koin.dsl.module

/**
 * Aggregated Koin module containing all screen-level DI definitions.
 */
val screensModules =
    module {
        includes(ActivesProfilesScreenDiLibrary().getModules())
        includes(DevProfileScreenDiLibrary().getModules())
        includes(InactivesProfilesScreenDiLibrary().getModules())
        includes(PersonalProfileFormScreenDiLibrary().getModules())
        includes(MainScreenDiLibrary().getModules())
    }

/**
 * Koin module providing the global [HexagonNavigator] instance.
 */
val navigatorModule =
    module {
        single { HexagonNavigator(startDestination = HomeRoute) }
    }
