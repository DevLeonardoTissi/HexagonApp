package br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.data

import br.com.leonardo.appcore.data.network.retrofit.HexagonRetrofit
import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.GithubUserInfoRemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.impl.GithubUserInfoRemoteSourceImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.impl.GithubUserInfoMapperImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.impl.GithubUserRepositoryImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.services.GithubApiService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class DevProfileDataDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            single<GithubApiService> {
                get<HexagonRetrofit>().createService(
                    baseUrl = GITHUB_API_BASE_URL,
                    serviceClass = GithubApiService::class.java,
                )
            }
            singleOf(::GithubUserInfoMapperImpl) { bind<GithubUserInfoMapper>() }
            singleOf(::GithubUserInfoRemoteSourceImpl) { bind<GithubUserInfoRemoteSource>() }
            singleOf(::GithubUserRepositoryImpl) { bind<GithubUserRepository>() }
        }
}

const val GITHUB_API_BASE_URL = "https://api.github.com/users/"
