package br.com.leonardo.ui.navigator

import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module

interface ScreenNavigator<R: Route, S : HexagonScreen<R>> {

    val screen: S

    @OptIn(KoinExperimentalAPI::class)
    fun registerNavigationModule() : Module

}