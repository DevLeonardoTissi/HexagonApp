package br.com.leonardo.hexagonapp.ui.screens.devprofile

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIData
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.model.DevProfileScreenState
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DevProfileUIDataTest {

    private lateinit var devProfileUIData: DevProfileUIData

    @Before
    fun setUp() {
        devProfileUIData = DevProfileUIData(DevProfileUIState())
    }

    @Test
    fun `must return correct initial state when create object`() {
        Assert.assertEquals(
            devProfileUIData.getState().screenState,
            DevProfileUIState().screenState
        )
        Assert.assertEquals(
            devProfileUIData.getState().isRefreshing,
            DevProfileUIState().isRefreshing
        )
        Assert.assertEquals(
            devProfileUIData.getState().showBottomSheetShareProfile,
            DevProfileUIState().isRefreshing
        )
    }

    @Test
    fun `must return correct screenState after change state`() {
        devProfileUIData.error()
        Assert.assertEquals(devProfileUIData.getState().screenState, DevProfileScreenState.Error)

        devProfileUIData.load()
        Assert.assertEquals(devProfileUIData.getState().screenState, DevProfileScreenState.Loading)

        devProfileUIData.success()
        Assert.assertEquals(devProfileUIData.getState().screenState, DevProfileScreenState.Success)
    }

    @Test
    fun `must return correct value after update isRefreshing`() {
        devProfileUIData.refresh(true)
        Assert.assertTrue(devProfileUIData.getState().isRefreshing)

        devProfileUIData.refresh(false)
        Assert.assertFalse(devProfileUIData.getState().isRefreshing)
    }

    @Test
    fun `must return correct value after call updateBottomSheetShareProfileVisibility function`() {
        devProfileUIData.updateBottomSheetShareProfileVisibility(true)
        Assert.assertTrue(devProfileUIData.getState().showBottomSheetShareProfile)

        devProfileUIData.updateBottomSheetShareProfileVisibility(false)
        Assert.assertFalse(devProfileUIData.getState().showBottomSheetShareProfile)
    }


}