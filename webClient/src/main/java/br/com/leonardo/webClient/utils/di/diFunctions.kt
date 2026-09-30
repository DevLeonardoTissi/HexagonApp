package br.com.leonardo.webClient.utils.di

import org.koin.core.context.GlobalContext


inline fun <reified T : Any> myInject(): T {
    return GlobalContext.get().get<T>()
}