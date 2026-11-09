package br.com.leonardo.appcore.presentation.navigator

import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind

inline fun <reified T : ScreenNavigator<*, *>> Module.registerScreenNavigation(crossinline instance: () -> T) {
    val navigator = instance()
    single(named(T::class.java.name)) { instance() } bind ScreenNavigator::class
    includes(navigator.registerNavigationModule())
}
