package br.com.leonardo.appcore.presentation.navigator

import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module

/**
 * Screen navigator
 *
 * @param R
 * @param S
 * @property screen
 */
interface ScreenNavigator<R : Route, S : HexagonScreen<R, *, *, *, *, *>> {
    val screen: S

    /**
     * Adds the navigation module
     *
     * @return the module
     */
    fun registerNavigationModule(): Module
}
