package br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider

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
            inactivesProfilesScreenContentProvider.contentContent is InactivesProfilesScreenContentContentProvider
        )
    }
}