package br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.model.DevProfileScreenState
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.layout.content.HexagonColumnContentLayout
import br.com.leonardo.ui.content.layout.content.HexagonSwipeRefreshContentLayout

class DevProfileScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<DevProfileState, DevProfileUIState> = HexagonColumnContentLayout(
        horizontalAlignment = Alignment.CenterHorizontally
    ),
    override val onRefreshAction: HexagonAction = DevProfileActions.Refresh

) : HexagonSwipeRefreshContentLayout<DevProfileState, DevProfileUIState>(contentLayout = contentLayout) {

    @Composable
    override fun Modifier.contentSwipeModifier(
        state: DevProfileState,
        uiState: DevProfileUIState
    ) = if (uiState.screenState == DevProfileScreenState.Success) {
        this
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    } else {
        this
            .fillMaxSize()
    }
}