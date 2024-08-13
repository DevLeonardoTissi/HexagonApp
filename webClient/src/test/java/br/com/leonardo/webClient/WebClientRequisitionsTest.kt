package br.com.leonardo.webClient

import br.com.leonardo.webClient.repository.GithubUserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class WebClientRequisitionsTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(webClientRepositoryModule)
    }

    private val repository by inject<GithubUserRepository>()

    @Test
    fun `must return true because the profile exists on github`() = runTest {
        assertNotNull(repository.getUserProfileInfo())
    }

    @Test
    fun `must return true because the project developer has a specific name`() = runTest {
        val developerName = "Leonardo Tissi"
        val profileInfo = repository.getUserProfileInfo()
        assertEquals(developerName, profileInfo?.name)
    }

    @Test
    fun `must return true because the profile has repositories`() = runTest {
        val repositories = repository.getUserRepositoriesInfo()
        assertNotNull(repositories)
    }
}