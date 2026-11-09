package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class ErrorSectionMapper : HexagonSectionMapper<DevProfileState, DevProfileUIState, ErrorSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState,
    ): ErrorSectionRender =
        ErrorSectionRender(
            buttonText = stringResource(R.string.buttonRetryLoadUserInfoText),
            errorTexts = listOf(stringResource(R.string.errorMessagingText)),
            iconRefreshDescription = stringResource(R.string.buttonRetryLoadUserInfoIconDescription),
        )
}
