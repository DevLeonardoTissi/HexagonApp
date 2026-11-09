package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel

/**
 * Use case interface for retrieving developer profile info.
 */
interface GetUserProfileInfoUseCase {
    /** Executes profile fetch. */
    suspend operator fun invoke(): Result<GitHubProfileInfoModel>
}
