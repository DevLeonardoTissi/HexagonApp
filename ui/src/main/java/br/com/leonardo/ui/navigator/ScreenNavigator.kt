package br.com.leonardo.ui.navigator

import androidx.navigation.NavGraphBuilder
import br.com.leonardo.ui.screen.HexagonScreen

interface ScreenNavigator<R: Route, S : HexagonScreen<R>> {

    val screen: S

    fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder)

}