package br.com.leonardo.webClient.usecase

import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

interface GetUserRepositoriesInfoUseCase {

    suspend operator fun invoke(): Result<List<GithubRepositoryInfoModel>>
}