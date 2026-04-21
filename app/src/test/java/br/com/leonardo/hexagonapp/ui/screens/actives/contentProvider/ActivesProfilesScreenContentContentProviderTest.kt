package br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist.ActivesProfilesListSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivesProfilesScreenContentContentProviderTest {

    private lateinit var activesProfilesScreenContentContentProvider: ActivesProfilesScreenContentContentProvider

    @Before
    fun setUp() {
        activesProfilesScreenContentContentProvider = ActivesProfilesScreenContentContentProvider()
    }

    @Test
    fun `must return corrects sections`() {
        val expectedTypes = listOf(
            ActivesProfilesListSection::class
        )
        val result = activesProfilesScreenContentContentProvider.getContent(
            ActivesProfilesState(), ActivesProfilesUiState()
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}