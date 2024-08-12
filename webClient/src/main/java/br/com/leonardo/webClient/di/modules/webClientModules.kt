package br.com.leonardo.webClient.di.modules

import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.repository.GithubUserRepositoryImpl
import br.com.leonardo.webClient.services.GithubApiService
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
    single<GithubUserRepository>{GithubUserRepositoryImpl(get())}
}