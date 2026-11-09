package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider.ActivesProfilesScreenContentContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist.ActivesProfilesListSection
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
        val expectedTypes =
            listOf(
                ActivesProfilesListSection::class,
            )
        val result =
            activesProfilesScreenContentContentProvider
                .getContent(
                    ActivesProfilesState(),
                    ActivesProfilesUiState(),
                ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}
