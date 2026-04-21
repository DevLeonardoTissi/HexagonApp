package br.com.leonardo.hexagonapp.ui.screens.devprofile.contentLayout

import androidx.compose.ui.Alignment
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.ui.content.layout.content.HexagonColumnContentLayout
import br.com.leonardo.ui.content.layout.content.HexagonSwipeRefreshContentLayout
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DevProfileScreenContentLayoutTest {

    private lateinit var devProfileScreenContentLayout: DevProfileScreenContentLayout

    @Before
    fun setUp() {
        devProfileScreenContentLayout = DevProfileScreenContentLayout()
    }

    @Test
    fun `must return corrects contents layout type`() {
        Assert.assertTrue(
            devProfileScreenContentLayout.contentLayout is HexagonColumnContentLayout
        )
    }

    @Test
    fun `must return true with column modifier`() {
        Assert.assertTrue(
            (devProfileScreenContentLayout.contentLayout as? HexagonColumnContentLayout)?.horizontalAlignment == Alignment.CenterHorizontally
        )
    }

    @Test
    fun `must return true with correct action on refresh`() {
        Assert.assertTrue(
            (devProfileScreenContentLayout  as? HexagonSwipeRefreshContentLayout<DevProfileState, DevProfileUIState>)?.onRefreshAction is DevProfileActions.Refresh
        )
    }

}