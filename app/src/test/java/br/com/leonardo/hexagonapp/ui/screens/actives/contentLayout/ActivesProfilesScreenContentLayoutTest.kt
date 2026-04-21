package br.com.leonardo.hexagonapp.ui.screens.actives.contentLayout

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivesProfilesScreenContentLayoutTest {

    private lateinit var activesProfilesScreenContentLayout: ActivesProfilesScreenContentLayout

    @Before
    fun setUp() {
        activesProfilesScreenContentLayout = ActivesProfilesScreenContentLayout()
    }

    @Test
    fun `must return corrects contents layout type`() {
        Assert.assertTrue(
            activesProfilesScreenContentLayout.contentLayout is ActivesProfilesScreenContentContentLayout
        )
    }


}