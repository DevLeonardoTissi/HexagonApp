package br.com.leonardo.ui.navigator

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import br.com.leonardo.ui.action.HexagonNavigationAction
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun HexagonNavigator3() {
    val entryProvider = koinEntryProvider<Route>()
    val navigator = koinInject<HexagonNavigator>()

    NavDisplay(
        backStack = navigator.backstack,
        onBack = { navigator.handleNavigatorAction(HexagonNavigationAction.GoBack) },
        entryProvider = entryProvider,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        )
    )
}