package br.com.leonardo.hexagonapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.navigator.NavEvent
import br.com.leonardo.ui.navigator.Route
import br.com.leonardo.ui.navigator.ScreenNavigator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.serialization.Serializable

import org.koin.java.KoinJavaComponent

class HexagonNavigatorImpl : HexagonNavigator {

    @Serializable
    object MainGraph

    private val _navigationEvents = Channel<NavEvent>(Channel.BUFFERED)
    override val navigationEvents = _navigationEvents.receiveAsFlow()

    override val screenNavigators: List<ScreenNavigator<*, *>> = KoinJavaComponent.getKoin().getAll()

    override val startDestination = MainGraph

    override fun registerAppGraph(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<MainGraph>(startDestination = HomeRoute) {
            screenNavigators.forEach { navigator ->
                navigator.registerScreenNavigator(navGraphBuilder = this)
            }
        }
    }

    override fun navigateTo(route: Route, navOptions: NavOptions?) {
        _navigationEvents.trySend(NavEvent.To(route, navOptions))
    }

    override fun goBack() {
        _navigationEvents.trySend(NavEvent.Back)
    }

    override fun popUp() {
        _navigationEvents.trySend(NavEvent.PopUp)
    }

}