package br.com.leonardo.hexagonapp.webClient.services

import br.com.leonardo.hexagonapp.webClient.model.GitHubProfileResponse
import br.com.leonardo.hexagonapp.webClient.model.GithubRepositoryResponse
import retrofit2.http.GET

interface GithubApiService {

    @GET("devleonardotissi")
    suspend fun getProfile(): GitHubProfileResponse
    @GET("devleonardotissi/repos?sort=created&direction=desc")
    suspend fun getRepositories(): List<GithubRepositoryResponse>
}