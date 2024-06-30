package br.com.leonardo.hexagonapp.webClient.services

import br.com.leonardo.hexagonapp.webClient.model.GitHubProfileInfoResponse
import br.com.leonardo.hexagonapp.webClient.model.GithubRepositoryInfoResponse
import retrofit2.http.GET

interface GithubApiService {

    @GET("devleonardotissi")
    suspend fun getUserProfileInfo(): GitHubProfileInfoResponse?

    @GET("devleonardotissi/repos?sort=created&direction=desc")
    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfoResponse>?
}