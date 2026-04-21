package br.com.leonardo.hexagonapp.ui.screens.inactives.contentLayout

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InactivesProfilesScreenContentLayoutTest {

    private lateinit var inactivesProfilesScreenContentLayout: InactivesProfilesScreenContentLayout

    @Before
    fun setUp() {
        inactivesProfilesScreenContentLayout = InactivesProfilesScreenContentLayout()
    }

    @Test
    fun `must return corrects contents layout type`() {
        Assert.assertTrue(
            inactivesProfilesScreenContentLayout.contentLayout is InactivesProfilesScreenContentContentLayout
        )
    }
}