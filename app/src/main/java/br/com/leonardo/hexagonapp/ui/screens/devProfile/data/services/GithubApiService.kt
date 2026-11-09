package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.services

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.response.GitHubProfileInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.response.GithubRepositoryInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Retrofit API interface for requesting user profile and repository data from GitHub REST API.
 */
interface GithubApiService {
    /**
     * Fetches user profile response.
     *
     * @param path Full URL or relative endpoint path.
     */
    @GET
    suspend fun getUserProfileInfo(
        @Url path: String,
    ): Response<GitHubProfileInfoResponse>

    /**
     * Fetches list of repositories response.
     *
     * @param path Full URL or relative endpoint path.
     * @param sort Query parameter for sorting repositories.
     * @param direction Query parameter for sort direction.
     */
    @GET
    suspend fun getUserRepositoriesInfo(
        @Url path: String,
        @Query("sort") sort: String,
        @Query("direction") direction: String,
    ): Response<List<GithubRepositoryInfoResponse>>
}
