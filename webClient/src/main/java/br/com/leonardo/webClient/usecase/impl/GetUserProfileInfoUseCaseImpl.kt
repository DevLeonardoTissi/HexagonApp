package br.com.leonardo.webClient.usecase.impl

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.usecase.GetUserProfileInfoUseCase

class GetUserProfileInfoUseCaseImpl(private val repository: GithubUserRepository) :
    GetUserProfileInfoUseCase {

    override suspend operator fun invoke(): Result<GitHubProfileInfoModel> {
       return repository.getUserProfileInfo()
    }
}