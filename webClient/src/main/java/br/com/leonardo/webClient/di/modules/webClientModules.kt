package br.com.leonardo.webClient.di.modules

import android.content.Context
import android.net.ConnectivityManager
import br.com.leonardo.webClient.config.OkHttpClientProviderConfig
import br.com.leonardo.webClient.config.OkHttpClientProviderConfigImpl
import br.com.leonardo.webClient.connectivity.NetworkStatus
import br.com.leonardo.webClient.connectivity.PlatformNetworkHandler
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
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_API_BASE_URL = "https://api.github.com/users/"

val webClientRepositoryModule = module {

    single<ConnectivityManager> {
        get<Context>().getSystemService(ConnectivityManager::class.java) as ConnectivityManager
    }
    single<NetworkStatus> { PlatformNetworkHandler(get<ConnectivityManager>()) }
    single<OkHttpClientProviderConfig> { OkHttpClientProviderConfigImpl(get<NetworkStatus>()) }
    single<OkHttpClient>{ get<OkHttpClientProviderConfig>().invoke() }

    single {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single { get<Retrofit>().create(GithubApiService::class.java) }
    single<GithubUserInfoMapper> { GithubUserInfoMapperImpl() }
    single<GithubUserInfoRemoteSource> { GithubUserInfoRemoteSourceImpl(get(), get()) }
    single<GithubUserRepository> { GithubUserRepositoryImpl(get()) }
    single<GetUserProfileInfoUseCase> { GetUserProfileInfoUseCaseImpl(get()) }
    single<GetUserRepositoriesInfoUseCase> { GetUserRepositoriesInfoUseCaseImpl(get()) }

}