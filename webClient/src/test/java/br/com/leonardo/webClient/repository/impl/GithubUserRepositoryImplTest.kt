package br.com.leonardo.webClient.repository.impl

import br.com.leonardo.webClient.exception.NetworkException
import br.com.leonardo.webClient.mock.Mocks
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GithubUserRepositoryImplTest : KoinTest {

    //APENAS PARA VER QUE PODEMOS UTILIZAR MODULOS DINAMICOS DO KOIN (MAS NÂO INDICADO AQUI, APENAS EM TESTES INSTRUMENTADOS)
//    @get:Rule
//    val koinTestRule = KoinTestRule.create {
    // ESSA LINHA PARA MOCKAR UMA CLASSE COM O KOIN
//        MockProvider.register { clazz -> mockkClass(clazz, relaxed = true) }

//        modules(webClientModuleForUnitTest)
//        printLogger()
//    }

    private val githubUserInfoRemoteSource = mockk<GithubUserInfoRemoteSource>()

    private lateinit var repository: GithubUserRepositoryImpl

    @Before
    fun setup() {
        repository = GithubUserRepositoryImpl(
            githubUserInfoRemoteSource = githubUserInfoRemoteSource
        )
    }

    @Test
    fun `should return success and with the correct UserProfileInfo model`() = runTest {
        coEvery { githubUserInfoRemoteSource.getUserProfileInfo() } returns Result.success(Mocks.defaultProfileModel)

        val repositoryResult = repository.getUserProfileInfo()

        assertTrue(repositoryResult.isSuccess)
        assertEquals(repositoryResult, Result.success(Mocks.defaultProfileModel))
    }

    @Test
    fun `should call the getUserProfileInfo function`() = runTest {
        coEvery { githubUserInfoRemoteSource.getUserProfileInfo() } returns Result.success(Mocks.defaultProfileModel)

        repository.getUserProfileInfo()
        coVerify { githubUserInfoRemoteSource.getUserProfileInfo() }
    }

    @Test
    fun `should return the same error result as the remote source`() = runTest {
        coEvery { githubUserInfoRemoteSource.getUserProfileInfo() } returns Result.failure(
            NetworkException()
        )

        val repositoryResult = repository.getUserProfileInfo()
        assertTrue(repositoryResult.isFailure)
        assertTrue(repositoryResult.exceptionOrNull() is NetworkException)
    }

    @Test
    fun `should return success and with the correct list of GithubRepositoryInfoModel`() = runTest {
        coEvery { githubUserInfoRemoteSource.getUserRepositoriesInfo() } returns Result.success(
            Mocks.repositoriesModelList
        )

        val repositoryResult = repository.getUserRepositoriesInfo()

        assertTrue(repositoryResult.isSuccess)
        assertEquals(repositoryResult, Result.success(Mocks.repositoriesModelList))
    }

    @Test
    fun `should call the getUserRepositoriesInfo function`() = runTest {
        coEvery { githubUserInfoRemoteSource.getUserRepositoriesInfo() } returns Result.success(
            Mocks.repositoriesModelList
        )

        repository.getUserRepositoriesInfo()
        coVerify { githubUserInfoRemoteSource.getUserRepositoriesInfo() }
    }

    @Test
    fun `should return the same error result as the remote source in getUserRepositoriesInfo function`() =
        runTest {
            coEvery { githubUserInfoRemoteSource.getUserRepositoriesInfo() } returns Result.failure(
                NetworkException()
            )

            val repositoryResult = repository.getUserRepositoriesInfo()
            assertTrue(repositoryResult.isFailure)
            assertTrue(repositoryResult.exceptionOrNull() is NetworkException)
        }


}
