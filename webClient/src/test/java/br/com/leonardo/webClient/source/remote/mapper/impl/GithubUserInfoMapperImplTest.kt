package br.com.leonardo.webClient.source.remote.mapper.impl

import br.com.leonardo.webClient.mock.Mocks
import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GithubUserInfoMapperImplTest {

    private lateinit var githubUserInfoMapperImpl: GithubUserInfoMapperImpl

    @Before
    fun setup() {
        githubUserInfoMapperImpl = GithubUserInfoMapperImpl()
    }

    @Test
    fun `should return correct GitHubProfileInfoModel`() {
        val fieldAvatarURlExample = "https:avatarUrl.com"
        val fieldHtmlURlExample = "https:htmlUrl.com"
        val fieldNameExample = "name"
        val fieldBlogExample = "blog"
        val fieldLocationExample = "location"
        val fieldBioExample = "bio example"
        val fieldPublicReposExample = 0

        val entity = GitHubProfileInfoResponse(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = fieldPublicReposExample
        )

        val model = githubUserInfoMapperImpl.toModel(githubProfileInfoResponse = entity)
        Assert.assertEquals(fieldAvatarURlExample, model.avatarUrl)
        Assert.assertEquals(fieldHtmlURlExample, model.htmlUrl)
        Assert.assertEquals(fieldNameExample, model.name)
        Assert.assertEquals(fieldBlogExample, model.blog)
        Assert.assertEquals(fieldLocationExample, model.location)
        Assert.assertEquals(fieldBioExample, model.bio)
        Assert.assertEquals(fieldPublicReposExample, model.publicRepos)
    }

    @Test
    fun `should return correct GitHubProfileInfoModel when null values`() {
        val entity = GitHubProfileInfoResponse()

        val model = githubUserInfoMapperImpl.toModel(githubProfileInfoResponse = entity)
        assertTrue(model.avatarUrl.isEmpty())
        assertTrue(model.htmlUrl.isEmpty())
        assertTrue(model.name.isEmpty())
        assertTrue(model.blog.isEmpty())
        assertTrue(model.location.isEmpty())
        assertTrue(model.bio.isEmpty())
        Assert.assertNull(model.publicRepos)
    }

    @Test
    fun `should return correct GithubRepositoryInfoModel`() {
        val fieldHtmlURlExample = "https:htmlUrl.com"
        val fieldNameExample = "name"
        val fieldDescriptionExample = "description example"

        val entityList = listOf(
            GithubRepositoryInfoResponse(
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                description = fieldDescriptionExample
            )
        )

        val modelList =
            githubUserInfoMapperImpl.toModel(githubRepositoryInfoListResponse = entityList)
        Assert.assertEquals(fieldHtmlURlExample, modelList.first().htmlUrl)
        Assert.assertEquals(fieldNameExample, modelList.first().name)
        Assert.assertEquals(fieldDescriptionExample, modelList.first().description)
    }

    @Test
    fun `should return correct GithubRepositoryInfoModel when null values`() {
        val entity = listOf(GithubRepositoryInfoResponse())

        val model = githubUserInfoMapperImpl.toModel(githubRepositoryInfoListResponse = entity)
        assertTrue(model.first().htmlUrl.isEmpty())
        assertTrue(model.first().name.isEmpty())
        assertTrue(model.first().description.isEmpty())
    }

    @Test
    fun `should return correct GithubRepositoryInfoModelList`() {
        val entityList = Mocks.repositoriesResponseList
        val modelList = Mocks.repositoriesModelList

        val modelMapperList =
            githubUserInfoMapperImpl.toModel(githubRepositoryInfoListResponse = entityList)
        assertEquals(modelMapperList, modelList)
    }
}

