package br.com.leonardo.webClient.usecase.impl

import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.usecase.GetUserRepositoriesInfoUseCase

class GetUserRepositoriesInfoUseCaseImpl(private val repository: GithubUserRepository) :
    GetUserRepositoriesInfoUseCase {

    override suspend fun invoke(): List<GithubRepositoryInfo>? {
        return repository.getUserRepositoriesInfo()
    }
}