package br.com.leonardo.webClient.usecase

import br.com.leonardo.webClient.model.GitHubProfileInfo

interface GetUserProfileInfoUseCase {
    suspend operator fun invoke(): GitHubProfileInfo?
}