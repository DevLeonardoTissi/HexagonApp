package br.com.leonardo.appcore.data.network.interceptor

import okhttp3.Interceptor

/**
 * Interceptor interface for verifying network status before executing requests.
 */
interface NetworkStatusInterceptor : Interceptor
