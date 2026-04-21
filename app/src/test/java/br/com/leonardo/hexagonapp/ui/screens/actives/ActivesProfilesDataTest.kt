package br.com.leonardo.hexagonapp.ui.screens.actives

import br.com.leonardo.hexagonapp.mock.MockData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivesProfilesDataTest {

    private lateinit var activesProfilesData: ActivesProfilesData

    @Before
    fun setUp() {
        activesProfilesData = ActivesProfilesData(ActivesProfilesState())
    }

    @Test
    fun `must return correct list when update profiles list`() {
        val profilesList = MockData.mockActivesProfiles
        activesProfilesData.updateProfilesList(profilesList)
        Assert.assertEquals(activesProfilesData.getState().activeList, profilesList)
    }

}