package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.impl

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserProfileInfoUseCase

/**
 * Implementation of [GetUserProfileInfoUseCase] delegating to [GithubUserRepository].
 *
 * @property repository Developer profile repository.
 */
class GetUserProfileInfoUseCaseImpl(
    private val repository: GithubUserRepository,
) : GetUserProfileInfoUseCase {
    override suspend fun invoke(): Result<GitHubProfileInfoModel> = repository.getUserProfileInfo()
}
