package br.com.leonardo.webClient.utils.di

import org.koin.core.context.GlobalContext


/**
 * My inject
 *
 * @param T
 * @return the t
 */
inline fun <reified T : Any> myInject(): T {
    return GlobalContext.get().get<T>()
}
