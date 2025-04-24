package br.com.leonardo.webClient.usecase.impl

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.usecase.GetUserProfileInfoUseCase

class GetUserProfileInfoUseCaseImpl(private val repository: GithubUserRepository) :
    GetUserProfileInfoUseCase {

    override suspend operator fun invoke(): GitHubProfileInfo? {
       return repository.getUserProfileInfo()
    }

     private suspend fun getUserProfileInfo(): GitHubProfileInfo? {
        return repository.getUserProfileInfo()
    }
}