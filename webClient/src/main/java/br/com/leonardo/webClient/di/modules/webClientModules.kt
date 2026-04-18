package br.com.leonardo.webClient.di.modules

import android.content.Context
import android.net.ConnectivityManager
import br.com.leonardo.webClient.config.OkHttpClientProviderConfig
import br.com.leonardo.webClient.config.impl.OkHttpClientProviderConfigImpl
import br.com.leonardo.webClient.connectivity.NetworkStatus
import br.com.leonardo.webClient.connectivity.PlatformNetworkHandler
import br.com.leonardo.webClient.interceptor.ErrorInterceptor
import br.com.leonardo.webClient.interceptor.LoggingInterceptor
import br.com.leonardo.webClient.interceptor.NetworkStatusInterceptor
import br.com.leonardo.webClient.interceptor.impl.ErrorInterceptorImpl
import br.com.leonardo.webClient.interceptor.impl.LoggingInterceptorImpl
import br.com.leonardo.webClient.interceptor.impl.NetworkStatusInterceptorImpl
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.repository.impl.GithubUserRepositoryImpl
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.impl.GithubUserInfoRemoteSourceImpl
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.webClient.source.remote.mapper.impl.GithubUserInfoMapperImpl
import br.com.leonardo.webClient.usecase.GetUserProfileInfoUseCase
import br.com.leonardo.webClient.usecase.GetUserRepositoriesInfoUseCase
import br.com.leonardo.webClient.usecase.impl.GetUserProfileInfoUseCaseImpl
import br.com.leonardo.webClient.usecase.impl.GetUserRepositoriesInfoUseCaseImpl
import br.com.leonardo.webClient.utils.GITHUB_API_BASE_URL
import br.com.leonardo.webClient.utils.networkMonitor.NetworkMonitor
import br.com.leonardo.webClient.utils.networkMonitor.impl.NetworkMonitorImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val webClientModule = module {

    single<ConnectivityManager> {
        get<Context>().getSystemService(ConnectivityManager::class.java) as ConnectivityManager
    }
    single<NetworkStatus> { PlatformNetworkHandler(get<ConnectivityManager>()) }
    single<NetworkStatusInterceptor> { NetworkStatusInterceptorImpl(get<NetworkStatus>()) }
    single<ErrorInterceptor> { ErrorInterceptorImpl() }
    single<LoggingInterceptor> { LoggingInterceptorImpl() }
    single<OkHttpClientProviderConfig> {
        OkHttpClientProviderConfigImpl(
            get<NetworkStatusInterceptor>(),
            get<LoggingInterceptor>(),
            get<ErrorInterceptor>()
        )
    }
    single<OkHttpClient> { get<OkHttpClientProviderConfig>().invoke() }

    single {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single { get<Retrofit>().create(GithubApiService::class.java) }
    single<GithubUserInfoMapper> { GithubUserInfoMapperImpl() }
    single<GithubUserInfoRemoteSource> { GithubUserInfoRemoteSourceImpl(get(), get()) }
    single<GithubUserRepository> { GithubUserRepositoryImpl(get()) }
    factory<GetUserProfileInfoUseCase> { GetUserProfileInfoUseCaseImpl(get()) }
    factory<GetUserRepositoriesInfoUseCase> { GetUserRepositoriesInfoUseCaseImpl(get()) }
    single<NetworkMonitor> { NetworkMonitorImpl(get<ConnectivityManager>()) }
}