package br.com.leonardo.webClient.services

import retrofit2.http.GET

interface GithubApiService {

    @GET("devleonardotissi")
    suspend fun getUserProfileInfo(): br.com.leonardo.webClient.model.GitHubProfileInfoResponse?

    @GET("devleonardotissi/repos?sort=created&direction=desc")
    suspend fun getUserRepositoriesInfo(): List<br.com.leonardo.webClient.model.GithubRepositoryInfoResponse>?
}