package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.mock.Mocks
import br.com.leonardo.webClient.services.GithubApiService
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

class GithubUserInfoRemoteSourceImplTest : KoinTest {


    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()

        // Registra o MockK como o provedor oficial de mocks para o Koin.
        // O Koin não cria mocks nativamente; essa ponte diz ao Koin:
        // "Sempre que eu pedir um 'declareMock', use o MockK para fabricar a classe (clazz)".
        // 'relaxed = true' evita erros caso uma função do mock seja chamada sem ter sido configurada.
        MockProvider.register { clazz -> mockkClass(clazz, relaxed = true) }
        modules(webClientModuleForUnitTest)
    }

    private val githubUserInfoRemoteSourceImpl by inject<GithubUserInfoRemoteSource>()

    @Test
    fun `must return a default profile`() = runTest {
        declareMock<GithubApiService> {
            coEvery { getUserProfileInfo() } returns null
        }

        val userProfile = githubUserInfoRemoteSourceImpl.getUserProfileInfo()
        assertEquals(userProfile, Mocks.defaultProfileModel)
    }

    @Test
    fun `not should return a default profile`() = runTest {
        declareMock<GithubApiService> {
            coEvery { getUserProfileInfo() } returns Mocks.profileResponse
        }
        val userProfile = githubUserInfoRemoteSourceImpl.getUserProfileInfo()
        assertNotEquals(Mocks.defaultProfileModel, userProfile)
    }


    @Test
    fun `must return repositories because the profile has repositories`() = runTest {
        declareMock<GithubApiService> {
            coEvery { getUserRepositoriesInfo() } returns Mocks.repositoriesResponseList
        }
        val repositories = githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()
        assertTrue(repositories.isNotEmpty())
    }

    @Test
    fun `must return a empty list because the profile has repositories`() = runTest {
        declareMock<GithubApiService> {
            coEvery { getUserRepositoriesInfo() } returns null
        }
        val repositories = githubUserInfoRemoteSourceImpl.getUserRepositoriesInfo()
        assertTrue(repositories.isEmpty())
    }

}