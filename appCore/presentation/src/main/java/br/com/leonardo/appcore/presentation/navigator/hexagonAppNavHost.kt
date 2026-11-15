package br.com.leonardo.appcore.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import br.com.leonardo.appcore.presentation.action.HexagonNavigationAction
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.component.KoinScopeComponent

/**
 * Composable host displaying the Hexagon navigation graph using Navigation3 and Koin.
 */
@OptIn(KoinExperimentalAPI::class)
@Composable
fun HexagonNavigator3() {
    val entryProvider = koinEntryProvider<SubfeatureInnerRoute>()
    val context = LocalContext.current
    val navigator =
        (context as? KoinScopeComponent)?.scope?.getOrNull<HexagonScreenInnerNavigator>()
            ?: koinInject<HexagonScreenInnerNavigator>()

    NavDisplay(
        backStack = navigator.backstack,
        onBack = { navigator.handleNavigatorAction(HexagonNavigationAction.GoBack) },
        entryProvider = entryProvider,
        entryDecorators =
            listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
    )
}
