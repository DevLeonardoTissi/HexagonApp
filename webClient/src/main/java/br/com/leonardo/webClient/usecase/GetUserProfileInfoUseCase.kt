package br.com.leonardo.webClient.usecase

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel

interface GetUserProfileInfoUseCase {
    suspend operator fun invoke(): Result<GitHubProfileInfoModel>
}