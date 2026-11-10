package br.com.leonardo.hexagonapp.ui.screens.devprofile.data.entity.response

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GithubRepositoryInfoResponseEntity
import org.junit.Assert
import org.junit.Test

class GithubRepositoryInfoResponseEntityTest {
    private val fieldHtmlURlExample = "https:htmlUrl.com"
    private val fieldNameExample = "name"
    private val fieldDescriptionExample = "description example"

    @Test
    fun `should return all the correct fields`() {
        val entity =
            GithubRepositoryInfoResponseEntity(
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                description = fieldDescriptionExample,
            )

        Assert.assertEquals(fieldHtmlURlExample, entity.htmlUrl)
        Assert.assertEquals(fieldNameExample, entity.name)
        Assert.assertEquals(fieldDescriptionExample, entity.description)
    }

    @Test
    fun `assert not equals method`() {
        val entity1 =
            GithubRepositoryInfoResponseEntity(
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                description = fieldDescriptionExample,
            )

        val entity2 =
            GithubRepositoryInfoResponseEntity(
                htmlUrl = "https:htmlUrl.com.br",
                name = "repository name",
                description = "repository description",
            )

        Assert.assertNotEquals(entity1, entity2)
    }

    @Test
    fun `assert equals method`() {
        val entity1 =
            GithubRepositoryInfoResponseEntity(
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                description = fieldDescriptionExample,
            )

        val entity2 =
            GithubRepositoryInfoResponseEntity(
                htmlUrl = fieldHtmlURlExample,
                name = fieldNameExample,
                description = fieldDescriptionExample,
            )

        Assert.assertEquals(entity1, entity2)
    }

    @Test
    fun `assert null values`() {
        val entityWithNullValues = GithubRepositoryInfoResponseEntity()

        Assert.assertNull(entityWithNullValues.htmlUrl)
        Assert.assertNull(entityWithNullValues.name)
        Assert.assertNull(entityWithNullValues.description)
    }
}
