package br.com.leonardo.hexagonapp.ui.screens.main.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.action.ActivityHandler
import br.com.leonardo.appcore.presentation.navigator.HexagonScreenInnerNavigator
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.route.HomeRoute
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainActivity
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class MainPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            viewModelOf(::MainViewModel)
            scope<MainActivity> {
                scoped<ActivityHandler> { get<MainActivity>() as ActivityHandler }
                scoped { HexagonScreenInnerNavigator(startDestination = HomeRoute) }
            }
        }
}
