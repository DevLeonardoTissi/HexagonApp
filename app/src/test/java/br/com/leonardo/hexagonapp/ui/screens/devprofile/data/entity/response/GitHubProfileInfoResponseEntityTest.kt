package br.com.leonardo.hexagonapp.ui.screens.devprofile.data.entity.response

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GitHubProfileInfoResponseEntity
import org.junit.Assert
import org.junit.Test

class GitHubProfileInfoResponseEntityTest {
    private val fieldAvatarURlExample = "https:avatarUrl.com"
    private val fieldHtmlURlExample = "https:htmlUrl.com"
    private val fieldNameExample = "name"
    private val fieldBlogExample = "blog"
    private val fieldLocationExample = "location"
    private val fieldBioExample = "bio example"
    private val fieldPublicReposExample = 0

    @Test
    fun `should return all the correct fields`() {
        val entity =
            GitHubProfileInfoResponseEntity(
                avatarUrl = fieldAvatarURlExample,
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                blog = fieldBlogExample,
                location = fieldLocationExample,
                bio = fieldBioExample,
                publicRepos = fieldPublicReposExample,
            )

        Assert.assertEquals(fieldAvatarURlExample, entity.avatarUrl)
        Assert.assertEquals(fieldHtmlURlExample, entity.htmlUrl)
        Assert.assertEquals(fieldNameExample, entity.name)
        Assert.assertEquals(fieldBlogExample, entity.blog)
        Assert.assertEquals(fieldLocationExample, entity.location)
        Assert.assertEquals(fieldBioExample, entity.bio)
        Assert.assertEquals(fieldPublicReposExample, entity.publicRepos)
    }

    @Test
    fun `assert not equals method`() {
        val entity1 =
            GitHubProfileInfoResponseEntity(
                avatarUrl = fieldAvatarURlExample,
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                blog = fieldBlogExample,
                location = fieldLocationExample,
                bio = fieldBioExample,
                publicRepos = fieldPublicReposExample,
            )

        val entity2 =
            GitHubProfileInfoResponseEntity(
                avatarUrl = "https:avatarUrl2.com.br",
                htmlUrl = "https:htmlUrl.com.br",
                name = "name2",
                blog = "blog2",
                location = "location2",
                bio = "bio example2",
                publicRepos = 1,
            )

        Assert.assertNotEquals(entity1, entity2)
    }

    @Test
    fun `assert equals method`() {
        val entity1 =
            GitHubProfileInfoResponseEntity(
                avatarUrl = fieldAvatarURlExample,
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                blog = fieldBlogExample,
                location = fieldLocationExample,
                bio = fieldBioExample,
                publicRepos = fieldPublicReposExample,
            )

        val entity2 =
            GitHubProfileInfoResponseEntity(
                avatarUrl = fieldAvatarURlExample,
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                blog = fieldBlogExample,
                location = fieldLocationExample,
                bio = fieldBioExample,
                publicRepos = fieldPublicReposExample,
            )

        Assert.assertEquals(entity1, entity2)
    }

    @Test
    fun `assert null values`() {
        val entityWithNullValues = GitHubProfileInfoResponseEntity()

        Assert.assertNull(entityWithNullValues.avatarUrl)
        Assert.assertNull(entityWithNullValues.htmlUrl)
        Assert.assertNull(entityWithNullValues.name)
        Assert.assertNull(entityWithNullValues.blog)
        Assert.assertNull(entityWithNullValues.location)
        Assert.assertNull(entityWithNullValues.bio)
        Assert.assertNull(entityWithNullValues.publicRepos)
    }
}
