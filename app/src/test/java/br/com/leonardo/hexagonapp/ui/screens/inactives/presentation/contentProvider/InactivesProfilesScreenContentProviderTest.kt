package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider.InactivesProfilesScreenContentContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider.InactivesProfilesScreenContentProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InactivesProfilesScreenContentProviderTest {
    private lateinit var inactivesProfilesScreenContentProvider: InactivesProfilesScreenContentProvider

    @Before
    fun setUp() {
        inactivesProfilesScreenContentProvider = InactivesProfilesScreenContentProvider()
    }

    @Test
    fun `must return corrects contents type`() {
        Assert.assertTrue(
            inactivesProfilesScreenContentProvider.contentContent is InactivesProfilesScreenContentContentProvider,
        )
    }
}
