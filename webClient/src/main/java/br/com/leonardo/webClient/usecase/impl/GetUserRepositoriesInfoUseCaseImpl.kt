package br.com.leonardo.webClient.usecase.impl

import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.usecase.GetUserRepositoriesInfoUseCase

class GetUserRepositoriesInfoUseCaseImpl(private val repository: GithubUserRepository) :
    GetUserRepositoriesInfoUseCase {

    override suspend fun invoke(): Result<List<GithubRepositoryInfoModel>> {
        return repository.getUserRepositoriesInfo()
    }
}