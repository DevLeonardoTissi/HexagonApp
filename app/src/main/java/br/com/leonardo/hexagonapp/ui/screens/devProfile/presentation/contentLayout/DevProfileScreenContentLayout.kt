package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonColumnContentLayout
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonSwipeRefreshContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileActions
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.model.DevProfileScreenState

class DevProfileScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<DevProfileState, DevProfileUIState> =
        HexagonColumnContentLayout(
            horizontalAlignment = Alignment.CenterHorizontally,
        ),
) : HexagonSwipeRefreshContentLayout<DevProfileState, DevProfileUIState>(contentLayout = contentLayout) {
    override val onRefreshAction: HexagonAction = DevProfileActions.Refresh

    @Composable
    override fun Modifier.contentSwipeModifier(
        state: DevProfileState,
        uiState: DevProfileUIState,
    ) = if (uiState.screenState == DevProfileScreenState.Success) {
        this
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    } else {
        this
            .fillMaxSize()
    }
}
