package br.com.leonardo.webClient.di.modules

import br.com.leonardo.appcore.data.network.retrofit.HexagonRetrofit
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
import org.koin.dsl.module


val webClientModule = module {

    single<GithubApiService> {
        val hexagonRetrofit = get<HexagonRetrofit>()
        hexagonRetrofit.createService(baseUrl = GITHUB_API_BASE_URL, serviceClass = GithubApiService::class.java)
    }
    single<GithubUserInfoMapper> { GithubUserInfoMapperImpl() }
    single<GithubUserInfoRemoteSource> { GithubUserInfoRemoteSourceImpl(get(), get()) }
    single<GithubUserRepository> { GithubUserRepositoryImpl(get()) }
  

}

internal const val GITHUB_API_BASE_URL = "https://api.github.com/users/"
