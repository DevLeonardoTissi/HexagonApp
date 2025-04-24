package br.com.leonardo.webClient.usecase

import br.com.leonardo.webClient.model.GithubRepositoryInfo

interface GetUserRepositoriesInfoUseCase {

    suspend operator fun invoke(): List<GithubRepositoryInfo>?
}