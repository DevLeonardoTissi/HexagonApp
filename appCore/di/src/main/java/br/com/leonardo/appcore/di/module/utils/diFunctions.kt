package br.com.leonardo.appcore.di.module.utils

import org.koin.core.context.GlobalContext

/**
 * My inject
 *
 * @param T
 * @return the t
 */
inline fun <reified T : Any> myInject(): T = GlobalContext.get().get()
