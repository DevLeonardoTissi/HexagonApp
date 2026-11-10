package br.com.leonardo.appcore.di.module.utils

import org.koin.core.context.GlobalContext

/**
 * Inline reified extension function to resolve a dependency from Koin [GlobalContext].
 *
 * @param T The type of dependency to resolve.
 * @return The resolved instance of [T].
 */
inline fun <reified T : Any> myInject(): T = GlobalContext.get().get()
