package br.com.leonardo.webClient.services

import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubApiService {

    @GET
    suspend fun getUserProfileInfo(
        @Url path: String
    ): Response<GitHubProfileInfoResponse>

    @GET
    suspend fun getUserRepositoriesInfo(
        @Url path: String,
        @Query("sort") sort: String,
        @Query("direction") direction: String
    ): Response<List<GithubRepositoryInfoResponse>>
}