package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel

interface GetUserProfileInfoUseCase {
    suspend operator fun invoke(): Result<GitHubProfileInfoModel>
}
