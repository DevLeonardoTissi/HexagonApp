package br.com.leonardo.webClient.repository.impl

import br.com.leonardo.webClient.mock.Mocks
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.webClientModuleForUnitTest
import io.mockk.coEvery
import io.mockk.mockkClass
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.MockProvider
import org.koin.test.mock.declareMock
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class GithubUserRepositoryImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        MockProvider.register { clazz -> mockkClass(clazz, relaxed = true) }
        modules(webClientModuleForUnitTest)
        printLogger()
    }

    private val repository by inject<GithubUserRepository>()

    @Test
    fun `must return true because GithubUserInfoRemoteSource return a default profile`() = runTest {
        declareMock<GithubUserInfoRemoteSource> {
            coEvery { getUserProfileInfo() } returns Mocks.defaultProfileModel
        }

        val userProfile = repository.getUserProfileInfo()
        assertEquals(userProfile, Mocks.defaultProfileModel)
    }

    @Test
    fun `not should return true because GithubUserInfoRemoteSource not return a default profile`() =
        runTest {
            declareMock<GithubUserInfoRemoteSource> {
                coEvery { getUserProfileInfo() } returns Mocks.notDefaultProfileModel
            }

            val userProfile = repository.getUserProfileInfo()
            assertNotEquals(userProfile, Mocks.defaultProfileModel)
        }


    @Test
    fun `must return repositories because GithubUserInfoRemoteSource returns a list`() = runTest {
        declareMock<GithubUserInfoRemoteSource> {
            coEvery { getUserRepositoriesInfo() } returns Mocks.repositoriesModelList
        }
        val repositories = repository.getUserRepositoriesInfo()
        assertEquals(Mocks.repositoriesModelList, repositories)
    }

    @Test
    fun `must return repositories because GithubUserInfoRemoteSource returns a empty list`() =
        runTest {
            declareMock<GithubUserInfoRemoteSource> {
                coEvery { getUserRepositoriesInfo() } returns emptyList()
            }
            val repositories = repository.getUserRepositoriesInfo()
            assertTrue(repositories.isEmpty())
        }

}
