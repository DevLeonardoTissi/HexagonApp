package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

/**
 * Use case interface for retrieving developer repositories list.
 */
interface GetUserRepositoriesInfoUseCase {
    /** Executes repositories list fetch. */
    suspend operator fun invoke(): Result<List<GithubRepositoryInfoModel>>
}
