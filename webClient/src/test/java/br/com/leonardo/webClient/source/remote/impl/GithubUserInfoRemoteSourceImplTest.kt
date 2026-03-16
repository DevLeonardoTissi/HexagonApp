package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.exception.NetworkException
import br.com.leonardo.webClient.mock.Mocks
import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GithubUserInfoRemoteSourceImplTest : KoinTest {

    private val githubApiService = mockk<GithubApiService>()
    private val mapper = mockk<GithubUserInfoMapper>()
    private lateinit var githubUserInfoRemoteSourceImpl: GithubUserInfoRemoteSource

    @Before
    fun setup() {
        githubUserInfoRemoteSourceImpl = GithubUserInfoRemoteSourceImpl(
            githubProfileService = githubApiService,
            mapper = mapper
        )
    }

    @Test
    fun `should return success when api returns valid data`() = runTest {
        val mockResponse = Mocks.profileResponse
        val mockModel = Mocks.notDefaultProfileModel

        coEvery { githubApiService.getUserProfileInfo() } returns mockResponse
        every { mapper.toModel(mockResponse) } returns mockModel

        val result = githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        assertTrue(result.isSuccess)
        assertEquals(mockModel, result.getOrNull())
    }


    @Test
    fun `should call mapper when api return success`() = runTest {
        val mockResponse = Mocks.profileResponse
        val mockModel = Mocks.notDefaultProfileModel

        coEvery { githubApiService.getUserProfileInfo() } returns mockResponse
        every { mapper.toModel(mockResponse) } returns mockModel

        githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        verify { mapper.toModel(githubProfileInfoResponse = mockResponse) }
    }


    @Test
    fun `should return failure when api throws exception`() = runTest {
        coEvery { githubApiService.getUserProfileInfo() } throws NetworkException()
        val result = githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is NetworkException)
    }


    @Test
    fun `should not call mapper when api return error`() = runTest {
        coEvery { githubApiService.getUserProfileInfo() } throws NetworkException()
        githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        verify(exactly = 0) { mapper.toModel(githubProfileInfoResponse = any<GitHubProfileInfoResponse>()) }
    }

    @Test
    fun `should not call mapper when api return empty response`() = runTest {
        coEvery { githubApiService.getUserProfileInfo() } returns null
        githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        verify(exactly = 0) { mapper.toModel(githubProfileInfoResponse = any<GitHubProfileInfoResponse>()) }
    }

    @Test
    fun `should return failure when api return empty response`() = runTest {
        coEvery { githubApiService.getUserProfileInfo() } returns null
        val result = githubUserInfoRemoteSourceImpl.getUserProfileInfo()

        assertTrue(result.isFailure)
    }

    @Test
    fun `should return success when api returns valid list data`() = runTest {
        val mockResponseList = Mocks.repositoriesResponseList
        val mockModelList = Mocks.repositoriesModelList

        coEvery { githubApiService.getUserRepositoriesInfo() } returns mockResponseList
        every { mapper.toModel(githubRepositoryInfoListResponse = mockResponseList) } returns mockModelList

        val result = githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        assertTrue(result.isSuccess)
        assertEquals(mockModelList, result.getOrNull())
    }

    @Test
    fun `should call mapper when api return success list`() = runTest {
        val mockResponseList = Mocks.repositoriesResponseList
        val mockModelList = Mocks.repositoriesModelList

        coEvery { githubApiService.getUserRepositoriesInfo() } returns mockResponseList
        every { mapper.toModel(githubRepositoryInfoListResponse = mockResponseList) } returns mockModelList

        githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        verify { mapper.toModel(githubRepositoryInfoListResponse = mockResponseList) }
    }

    @Test
    fun `should return failure when api throws exception in get repositories list method`() = runTest {
        coEvery { githubApiService.getUserRepositoriesInfo() } throws NetworkException()
        val result = githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is NetworkException)
    }

    @Test
    fun `should not call mapper when api return error in get repositories list method`() = runTest {
        coEvery { githubApiService.getUserRepositoriesInfo() } throws NetworkException()
        githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        verify(exactly = 0) { mapper.toModel(githubRepositoryInfoListResponse = any<List<GithubRepositoryInfoResponse>>()) }
    }

    @Test
    fun `should not call mapper when api return empty list response`() = runTest {
        coEvery { githubApiService.getUserRepositoriesInfo() } returns null
        githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        verify(exactly = 0) { mapper.toModel(githubRepositoryInfoListResponse = any<List<GithubRepositoryInfoResponse>>()) }
    }

    @Test
    fun `should return failure when api return empty list response`() = runTest {
        coEvery { githubApiService.getUserRepositoriesInfo() } returns null
        val result = githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()

        assertTrue(result.isFailure)
    }
}