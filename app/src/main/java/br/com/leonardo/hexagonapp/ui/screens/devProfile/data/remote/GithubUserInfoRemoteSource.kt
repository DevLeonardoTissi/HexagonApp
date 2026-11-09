package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote

import br.com.leonardo.appcore.data.network.source.RemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

interface GithubUserInfoRemoteSource : RemoteSource {
    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>>
}
