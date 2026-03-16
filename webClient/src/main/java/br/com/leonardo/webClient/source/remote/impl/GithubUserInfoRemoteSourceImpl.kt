package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.exception.EmptyResponseException
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper

class GithubUserInfoRemoteSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper
) : GithubUserInfoRemoteSource {

    override suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel> =
        requestNotNullable {
            githubProfileService.getUserProfileInfo()
        }.map { response ->
            mapper.toModel(githubProfileInfoResponse = response)
        }


    override suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>> =
        requestNotNullable {
            githubProfileService.getUserRepositoriesInfo()
        }.map { response ->
            mapper.toModel(githubRepositoryInfoListResponse = response)
        }
}


//RE = Response
suspend fun <RE> requestNotNullable(
    block: suspend () -> RE?,
): Result<RE> {
    return try {
        val response = block()
        if (response != null) {
            Result.success(response)
        } else {
            Result.failure(EmptyResponseException())
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

}