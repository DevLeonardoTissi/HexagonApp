package br.com.leonardo.appcore.presentation.navigator

import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind

/**
 * Extension function on Koin [Module] to register a [ScreenNavigator] and include its navigation module.
 *
 * @param T The [ScreenNavigator] type.
 * @param instance Lambda providing the navigator instance.
 */
inline fun <reified T : ScreenNavigator<*, *>> Module.registerScreenNavigation(crossinline instance: () -> T) {
    val navigator = instance()
    single(named(T::class.java.name)) { instance() } bind ScreenNavigator::class
    includes(navigator.registerNavigationModule())
}
