package br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivesProfilesScreenContentProviderTest {

    private lateinit var activesProfilesScreenContentProvider: ActivesProfilesScreenContentProvider

    @Before
    fun setUp() {
        activesProfilesScreenContentProvider = ActivesProfilesScreenContentProvider()
    }

    @Test
    fun `must return corrects contents type`() {
        Assert.assertTrue(
            activesProfilesScreenContentProvider.contentContent is ActivesProfilesScreenContentContentProvider
        )
    }
}