package br.com.leonardo.appcore.presentation.navigator

import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import org.koin.core.module.Module

/**
 * Interface defining a screen navigator providing a screen and its navigation Koin module.
 *
 * @param R The [Route] type associated with the screen.
 * @param S The [HexagonScreen] type.
 */
interface ScreenNavigator<R : Route, S : HexagonScreen<R, *, *, *, *, *>> {
    /** The screen instance associated with this navigator. */
    val screen: S

    /**
     * Registers and returns the Koin [Module] required for screen navigation.
     *
     * @return [Module] containing screen dependencies.
     */
    fun registerNavigationModule(): Module
}
