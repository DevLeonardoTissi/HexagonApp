package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider.InactivesProfilesScreenContentContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist.InactivesProfilesListSection
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
        val expectedTypes =
            listOf(
                InactivesProfilesListSection::class,
            )
        val result =
            inactivesProfilesScreenContentContentProvider
                .getContent(
                    InactivesProfilesState(),
                    InactivesProfilesUiState(),
                ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}
