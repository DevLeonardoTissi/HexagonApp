package br.com.leonardo.webClient.models.entity.response

import org.junit.Assert
import org.junit.Test

class GithubRepositoryInfoResponseTest {

    private val fieldHtmlURlExample = "https:htmlUrl.com"
    private val fieldNameExample = "name"
    private val fieldDescriptionExample = "description example"

    @Test
    fun `should return all the correct fields`() {
        val entity = GithubRepositoryInfoResponse(
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
        val entity1 = GithubRepositoryInfoResponse(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        val entity2 = GithubRepositoryInfoResponse(
            htmlUrl = "https:htmlUrl.com.br",
            name = "repository name",
            description = "repository description"
        )

        Assert.assertNotEquals(entity1, entity2)
    }

    @Test
    fun `assert equals method`() {
        val entity1 = GithubRepositoryInfoResponse(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        val entity2 = GithubRepositoryInfoResponse(
            htmlUrl = fieldHtmlURlExample,
            name = fieldNameExample,
            description = fieldDescriptionExample
        )

        Assert.assertEquals(entity1, entity2)
    }

    @Test
    fun `assert null values`() {
        val entityWithNullValues = GithubRepositoryInfoResponse()

        Assert.assertNull(entityWithNullValues.htmlUrl)
        Assert.assertNull(entityWithNullValues.name)
        Assert.assertNull(entityWithNullValues.description)

    }
}