package br.com.leonardo.ui.screen

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.navigator.Route

interface HexagonScreen<R: Route> {

    @Composable
    fun Content(arguments: R? = null)

}