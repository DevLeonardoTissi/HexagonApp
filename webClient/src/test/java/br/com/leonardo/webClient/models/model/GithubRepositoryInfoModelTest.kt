package br.com.leonardo.webClient.models.model

import org.junit.Assert
import org.junit.Test

class GithubRepositoryInfoModelTest {

    private val fieldHtmlURlExample = "https:htmlUrl.com"
    private val fieldNameExample = "name"
    private val fieldDescriptionExample = "description example"

    @Test
    fun `should return all the correct fields`() {
        val entity = GithubRepositoryInfoModel(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        Assert.assertEquals(fieldHtmlURlExample, entity.htmlUrl)
        Assert.assertEquals(fieldNameExample, entity.name)
        Assert.assertEquals(fieldDescriptionExample, entity.description)

    }

    @Test
    fun `assert not equals method`() {
        val entity1 = GithubRepositoryInfoModel(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        val entity2 = GithubRepositoryInfoModel(
            htmlUrl = "https:htmlUrl.com.br",
            name = "repository name",
            description = "repository description"
        )

        Assert.assertNotEquals(entity1, entity2)
    }

    @Test
    fun `assert equals method`() {
        val entity1 = GithubRepositoryInfoModel(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        val entity2 = GithubRepositoryInfoModel(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        Assert.assertEquals(entity1, entity2)
    }

    @Test
    fun `assert not null values`() {
        val entity = GithubRepositoryInfoModel(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        Assert.assertNotNull(entity.htmlUrl)
        Assert.assertNotNull(entity.name)
        Assert.assertNotNull(entity.description)

    }
}