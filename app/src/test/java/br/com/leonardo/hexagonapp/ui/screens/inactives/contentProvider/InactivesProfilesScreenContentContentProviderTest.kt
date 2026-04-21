package br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist.InactivesProfilesListSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InactivesProfilesScreenContentContentProviderTest {

    private lateinit var inactivesProfilesScreenContentContentProvider: InactivesProfilesScreenContentContentProvider

    @Before
    fun setUp() {
        inactivesProfilesScreenContentContentProvider =
            InactivesProfilesScreenContentContentProvider()
    }

    @Test
    fun `must return corrects sections`() {
        val expectedTypes = listOf(
            InactivesProfilesListSection::class
        )
        val result = inactivesProfilesScreenContentContentProvider.getContent(
            InactivesProfilesState(), InactivesProfilesUiState()
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}