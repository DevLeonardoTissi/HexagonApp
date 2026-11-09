package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.impl

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserRepositoriesInfoUseCase

class GetUserRepositoriesInfoUseCaseImpl(
    private val repository: GithubUserRepository,
) : GetUserRepositoriesInfoUseCase {
    override suspend fun invoke(): Result<List<GithubRepositoryInfoModel>> = repository.getUserRepositoriesInfo()
}
