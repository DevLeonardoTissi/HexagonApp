package br.com.leonardo.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import kotlin.reflect.KClass

interface HexagonScreen {

    fun registerScreen(navGraphBuilder: NavGraphBuilder)

    @Composable
    fun Content(arguments: Any? = null)

}