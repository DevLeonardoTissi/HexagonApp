package br.com.leonardo.ui.navigator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.Flow

interface HexagonNavigator {

    val navigationEvents: Flow<NavEvent>
    val screenNavigators: List<ScreenNavigator<*>>
    val startDestination: Any

    fun registerAppGraph(navGraphBuilder: NavGraphBuilder)


    fun navigateTo(route: Route,  navOptions: NavOptions? = null)

    fun goBack()

    fun popUp()

}