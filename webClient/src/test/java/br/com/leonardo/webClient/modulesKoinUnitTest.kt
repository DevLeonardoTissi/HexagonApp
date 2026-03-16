package br.com.leonardo.webClient

import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.repository.impl.GithubUserRepositoryImpl
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.impl.GithubUserInfoRemoteSourceImpl
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.webClient.source.remote.mapper.impl.GithubUserInfoMapperImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_API_BASE_URL = "https://api.github.com/users/"

val webClientModuleForUnitTest = module {

    single {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(GithubApiService::class.java) }
    single<GithubUserInfoMapper> { GithubUserInfoMapperImpl() }
    single<GithubUserInfoRemoteSource> { GithubUserInfoRemoteSourceImpl(githubProfileService = get(), mapper = get()) }
    single<GithubUserRepository> { GithubUserRepositoryImpl(githubUserInfoRemoteSource = get()) }
}