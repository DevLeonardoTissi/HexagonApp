package br.com.leonardo.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import br.com.leonardo.ui.navigator.Route
import kotlin.reflect.KClass

interface HexagonScreen<R: Route> {

    @Composable
    fun Content(arguments: R? = null)

}