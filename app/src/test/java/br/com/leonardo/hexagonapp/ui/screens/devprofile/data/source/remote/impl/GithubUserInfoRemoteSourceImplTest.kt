package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.source.remote.impl

import br.com.leonardo.appcore.data.network.exception.EmptyResponseException
import br.com.leonardo.appcore.data.network.exception.NetworkException
import br.com.leonardo.appcore.data.network.utils.urlMap.URLMap
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GitHubProfileInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GithubRepositoryInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.GithubUserInfoRemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.impl.GithubUserInfoRemoteSourceImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.services.GithubApiService
import br.com.leonardo.hexagonapp.ui.screens.devProfile.mock.Mocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class GithubUserInfoRemoteSourceImplTest {
    private val githubApiService = mockk<GithubApiService>()
    private val mapper = mockk<GithubUserInfoMapper>()
    private val urlMap = mockk<URLMap>()

    private lateinit var githubUserInfoRemoteSource: GithubUserInfoRemoteSource

    private val mockedPath = "mocked/path"

    @Before
    fun setup() {
        startKoin {
            modules(
                module {
                    single<URLMap> {
                        urlMap
                    }
                },
            )
        }

        every {
            urlMap.map(
                any(),
                any(),
            )
        } returns mockedPath

        githubUserInfoRemoteSource =
            GithubUserInfoRemoteSourceImpl(
                githubProfileService = githubApiService,
                mapper = mapper,
            )
    }

    @After
    fun tearDown() {
        stopKoin()
    }

// ============================================================
// PROFILE
// ============================================================

    @Test
    fun `should return success when api returns valid profile data`() =
        runTest {
            val mockResponse = Mocks.profileResponse
            val mockBody = mockResponse.body()!!
            val mockModel = Mocks.notDefaultProfileModel

            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubProfileInfoResponse = mockBody,
                )
            } returns mockModel

            val result =
                githubUserInfoRemoteSource.getUserProfileInfo()

            assertTrue(result.isSuccess)
            assertEquals(
                mockModel,
                result.getOrNull(),
            )
        }

    @Test
    fun `should call mapper when api returns success`() =
        runTest {
            val mockResponse = Mocks.profileResponse
            val mockBody = mockResponse.body()!!
            val mockModel = Mocks.notDefaultProfileModel

            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubProfileInfoResponse = mockBody,
                )
            } returns mockModel

            githubUserInfoRemoteSource.getUserProfileInfo()

            verify(exactly = 1) {
                mapper.toModel(
                    githubProfileInfoResponse = mockBody,
                )
            }
        }

    @Test
    fun `should call api with mocked path`() =
        runTest {
            val mockResponse = Mocks.profileResponse
            val mockBody = mockResponse.body()!!
            val mockModel = Mocks.notDefaultProfileModel

            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubProfileInfoResponse = mockBody,
                )
            } returns mockModel

            githubUserInfoRemoteSource.getUserProfileInfo()

            coVerify(exactly = 1) {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            }
        }

    @Test
    fun `should return failure when api throws exception`() =
        runTest {
            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } throws NetworkException()

            val result =
                githubUserInfoRemoteSource.getUserProfileInfo()

            assertTrue(result.isFailure)
            assertIs<NetworkException>(
                result.exceptionOrNull(),
            )
        }

    @Test
    fun `should not call mapper when api throws exception`() =
        runTest {
            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } throws NetworkException()

            githubUserInfoRemoteSource.getUserProfileInfo()

            verify(exactly = 0) {
                mapper.toModel(
                    githubProfileInfoResponse =
                        any<GitHubProfileInfoResponseEntity>(),
                )
            }
        }

    @Test
    fun `should return failure when api returns empty profile response`() =
        runTest {
            val emptyResponse =
                Response.success<GitHubProfileInfoResponseEntity>(
                    null,
                )

            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } returns emptyResponse

            val result =
                githubUserInfoRemoteSource.getUserProfileInfo()

            assertTrue(result.isFailure)
            assertIs<EmptyResponseException>(
                result.exceptionOrNull(),
            )
        }

    @Test
    fun `should not call mapper when api returns empty profile response`() =
        runTest {
            val emptyResponse =
                Response.success<GitHubProfileInfoResponseEntity>(
                    null,
                )

            coEvery {
                githubApiService.getUserProfileInfo(
                    path = mockedPath,
                )
            } returns emptyResponse

            githubUserInfoRemoteSource.getUserProfileInfo()

            verify(exactly = 0) {
                mapper.toModel(
                    githubProfileInfoResponse =
                        any<GitHubProfileInfoResponseEntity>(),
                )
            }
        }

// ============================================================
// REPOSITORIES
// ============================================================

    @Test
    fun `should return success when api returns valid repositories data`() =
        runTest {
            val mockResponse = Mocks.repositoriesResponseList
            val mockBody = mockResponse.body()!!
            val mockModelList = Mocks.repositoriesModelList

            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubRepositoryInfoListResponse = mockBody,
                )
            } returns mockModelList

            val result =
                githubUserInfoRemoteSource.getUserRepositoriesInfo()

            assertTrue(result.isSuccess)
            assertEquals(
                mockModelList,
                result.getOrNull(),
            )
        }

    @Test
    fun `should call mapper when api returns success repositories list`() =
        runTest {
            val mockResponse = Mocks.repositoriesResponseList
            val mockBody = mockResponse.body()!!
            val mockModelList = Mocks.repositoriesModelList

            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubRepositoryInfoListResponse = mockBody,
                )
            } returns mockModelList

            githubUserInfoRemoteSource.getUserRepositoriesInfo()

            verify(exactly = 1) {
                mapper.toModel(
                    githubRepositoryInfoListResponse = mockBody,
                )
            }
        }

    @Test
    fun `should call api with mocked path and repository parameters`() =
        runTest {
            val mockResponse = Mocks.repositoriesResponseList
            val mockBody = mockResponse.body()!!
            val mockModelList = Mocks.repositoriesModelList

            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } returns mockResponse

            every {
                mapper.toModel(
                    githubRepositoryInfoListResponse = mockBody,
                )
            } returns mockModelList

            githubUserInfoRemoteSource.getUserRepositoriesInfo()

            coVerify(exactly = 1) {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            }
        }

    @Test
    fun `should return failure when api throws exception in repositories method`() =
        runTest {
            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } throws NetworkException()

            val result =
                githubUserInfoRemoteSource.getUserRepositoriesInfo()

            assertTrue(result.isFailure)
            assertIs<NetworkException>(
                result.exceptionOrNull(),
            )
        }

    @Test
    fun `should not call mapper when api throws exception in repositories method`() =
        runTest {
            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } throws NetworkException()

            githubUserInfoRemoteSource.getUserRepositoriesInfo()

            verify(exactly = 0) {
                mapper.toModel(
                    githubRepositoryInfoListResponse =
                        any<List<GithubRepositoryInfoResponseEntity>>(),
                )
            }
        }

    @Test
    fun `should return failure when api returns empty repositories response`() =
        runTest {
            val emptyResponse =
                Response.success<List<GithubRepositoryInfoResponseEntity>>(
                    null,
                )

            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } returns emptyResponse

            val result =
                githubUserInfoRemoteSource.getUserRepositoriesInfo()

            assertTrue(result.isFailure)
            assertIs<EmptyResponseException>(
                result.exceptionOrNull(),
            )
        }

    @Test
    fun `should not call mapper when api returns empty repositories response`() =
        runTest {
            val emptyResponse =
                Response.success<List<GithubRepositoryInfoResponseEntity>>(
                    null,
                )

            coEvery {
                githubApiService.getUserRepositoriesInfo(
                    path = mockedPath,
                    sort = "created",
                    direction = "desc",
                )
            } returns emptyResponse

            githubUserInfoRemoteSource.getUserRepositoriesInfo()

            verify(exactly = 0) {
                mapper.toModel(
                    githubRepositoryInfoListResponse =
                        any<List<GithubRepositoryInfoResponseEntity>>(),
                )
            }
        }
}
