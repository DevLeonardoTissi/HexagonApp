package br.com.leonardo.ui.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import br.com.leonardo.ui.screen.HexagonScreen
import kotlinx.coroutines.flow.Flow

interface HexagonNavigator {

    val navigationEvents: Flow<NavEvent>
    val screens: List<HexagonScreen>
    val startDestination: Any

    fun registerAppGraph(navGraphBuilder: NavGraphBuilder)


    fun navigateTo(route: Any,  navOptions: NavOptions? = null)

    fun goBack()

    fun popUp()

}