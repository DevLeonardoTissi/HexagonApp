package br.com.leonardo.webClient.di.modules

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
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_API_BASE_URL = "https://api.github.com/users/"

val webClientRepositoryModule = module {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    single {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single { get<Retrofit>().create(GithubApiService::class.java) }
    single<GithubUserInfoMapper> { GithubUserInfoMapperImpl() }
    single<GithubUserInfoRemoteSource> { GithubUserInfoRemoteSourceImpl(get(), get()) }
    single<GithubUserRepository> { GithubUserRepositoryImpl(get()) }
    single<GetUserProfileInfoUseCase> { GetUserProfileInfoUseCaseImpl(get()) }
    single<GetUserRepositoriesInfoUseCase> { GetUserRepositoriesInfoUseCaseImpl(get()) }
}