package br.com.leonardo.appcore.data.network.di

import android.content.Context
import android.net.ConnectivityManager
import br.com.leonardo.appcore.data.network.config.OkHttpClientProviderConfig
import br.com.leonardo.appcore.data.network.config.impl.OkHttpClientProviderConfigImpl
import br.com.leonardo.appcore.data.network.connectivity.NetworkStatus
import br.com.leonardo.appcore.data.network.connectivity.PlatformNetworkHandler
import br.com.leonardo.appcore.data.network.interceptor.ErrorInterceptor
import br.com.leonardo.appcore.data.network.interceptor.LoggingInterceptor
import br.com.leonardo.appcore.data.network.interceptor.NetworkStatusInterceptor
import br.com.leonardo.appcore.data.network.interceptor.impl.ErrorInterceptorImpl
import br.com.leonardo.appcore.data.network.interceptor.impl.LoggingInterceptorImpl
import br.com.leonardo.appcore.data.network.interceptor.impl.NetworkStatusInterceptorImpl
import br.com.leonardo.appcore.data.network.retrofit.HexagonRetrofit
import br.com.leonardo.appcore.data.network.utils.networkMonitor.NetworkMonitor
import br.com.leonardo.appcore.data.network.utils.networkMonitor.impl.NetworkMonitorImpl
import br.com.leonardo.appcore.data.network.utils.urlMap.URLMap
import br.com.leonardo.appcore.data.network.utils.urlMap.impl.URLMapImpl
import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class NetworkDI : HexagonLibrary {
    override fun getModules(): Module =
        module {
            single<ConnectivityManager> {
                get<Context>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            }
            singleOf(::PlatformNetworkHandler) { bind<NetworkStatus>() }
            singleOf(::NetworkStatusInterceptorImpl) { bind<NetworkStatusInterceptor>() }
            singleOf(::LoggingInterceptorImpl) { bind<LoggingInterceptor>() }
            singleOf(::ErrorInterceptorImpl) { bind<ErrorInterceptor>() }
            singleOf(::OkHttpClientProviderConfigImpl) { bind<OkHttpClientProviderConfig>() }
            singleOf(::URLMapImpl) { bind<URLMap>() }
            singleOf(::NetworkMonitorImpl) { bind<NetworkMonitor>() }
            singleOf(::HexagonRetrofit)
        }
}
