package br.com.leonardo.hexagonapp.ui.screens.inactives

import br.com.leonardo.hexagonapp.mock.MockData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InactivesProfilesDataTest {

    private lateinit var inactivesProfilesData: InactivesProfilesData

    @Before
    fun setUp() {
        inactivesProfilesData = InactivesProfilesData(InactivesProfilesState())
    }

    @Test
    fun `must return correct list when update profiles list`() {
        val profilesList = MockData.mockInactivesProfiles
        inactivesProfilesData.updateProfilesList(profilesList)
        Assert.assertEquals(inactivesProfilesData.getState().inactiveList, profilesList)
    }
}