package br.com.leonardo.ui.navigator

import androidx.navigation.NavOptions

sealed class NavEvent {
    data class To(val route: Route, val navOptions: NavOptions? = null) : NavEvent()
    object Back : NavEvent()

    object PopUp: NavEvent()
}