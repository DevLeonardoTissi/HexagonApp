package br.com.leonardo.webClient.models.model

import org.junit.Assert
import org.junit.Test

class GitHubProfileInfoModelTest {

    private val fieldAvatarURlExample = "https:avatarUrl.com"
    private val fieldHtmlURlExample = "https:htmlUrl.com"
    private val fieldNameExample = "name"
    private val fieldBlogExample = "blog"
    private val fieldLocationExample = "location"
    private val fieldBioExample = "bio example"
    private val fieldPublicReposExample = 0

    @Test
    fun `should return all the correct fields`() {
        val entity = GitHubProfileInfoModel(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = fieldPublicReposExample
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
        val entity1 = GitHubProfileInfoModel(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = fieldPublicReposExample
        )

        val entity2 = GitHubProfileInfoModel(
            avatarUrl = "https:avatarUrl2.com.br",
            htmlUrl = "https:htmlUrl.com.br",
            name = "name2",
            blog = "blog2",
            location = "location2",
            bio = "bio example2",
            publicRepos = 1
        )

        Assert.assertNotEquals(entity1, entity2)
    }

    @Test
    fun `assert equals method`() {
        val entity1 = GitHubProfileInfoModel(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = fieldPublicReposExample
        )

        val entity2 = GitHubProfileInfoModel(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = fieldPublicReposExample
        )

        Assert.assertEquals(entity1, entity2)
    }

    @Test
    fun `assert null and non null values`() {
        val entityWithNullValues = GitHubProfileInfoModel(
            avatarUrl = fieldAvatarURlExample,
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            blog = fieldBlogExample,
            location = fieldLocationExample,
            bio = fieldBioExample,
            publicRepos = null
        )

        Assert.assertNotNull(entityWithNullValues.avatarUrl)
        Assert.assertNotNull(entityWithNullValues.htmlUrl)
        Assert.assertNotNull(entityWithNullValues.name)
        Assert.assertNotNull(entityWithNullValues.blog)
        Assert.assertNotNull(entityWithNullValues.location)
        Assert.assertNotNull(entityWithNullValues.bio)
        Assert.assertNull(entityWithNullValues.publicRepos)
    }

}