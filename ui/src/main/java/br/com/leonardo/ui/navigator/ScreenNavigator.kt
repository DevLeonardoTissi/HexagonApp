package br.com.leonardo.ui.navigator

import androidx.navigation.NavGraphBuilder
import br.com.leonardo.ui.screen.HexagonScreen

interface ScreenNavigator<R: Route> {

    val screen: HexagonScreen<R>

    val destination: R

    fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder)

}