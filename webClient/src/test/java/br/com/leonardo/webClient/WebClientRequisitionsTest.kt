package br.com.leonardo.webClient

import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.services.GithubApiService
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Rule
import org.junit.Test
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class WebClientRequisitionsTest : KoinTest {

    private val GITHUB_API_BASE_URL = "https://api.github.com/users/"
    private val webClientRepositoryModule = module {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        single {
            Retrofit.Builder()
                .baseUrl(GITHUB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        single { get<Retrofit>().create(GithubApiService::class.java) }
        singleOf(::GithubUserRepository)
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(webClientRepositoryModule)
    }

    @Test
    fun `must return true because the profile exists on github`() = runTest {
        val repository by inject<GithubUserRepository>()
        assertNotNull(repository.getUserProfileInfo())
    }

    @Test
    fun `must return true because the project developer has a specific name`() = runTest {
        val repository by inject<GithubUserRepository>()
        val profileInfo = repository.getUserProfileInfo()
        assertEquals("Leonardo Tissi", profileInfo?.name)
    }

    @Test
    fun `must return true because the profile has repositories`() = runTest {
        val repository by inject<GithubUserRepository>()
        val repositories = repository.getUserRepositoriesInfo()
        assertNotNull(repositories)
    }
}