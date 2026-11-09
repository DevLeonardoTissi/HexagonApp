package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

interface GetUserRepositoriesInfoUseCase {
    suspend operator fun invoke(): Result<List<GithubRepositoryInfoModel>>
}
