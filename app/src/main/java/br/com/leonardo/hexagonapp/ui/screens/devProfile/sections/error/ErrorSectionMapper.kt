package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class ErrorSectionMapper :
    HexagonSectionMapper<DevProfileState, DevProfileUIState, ErrorSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState
    ): ErrorSectionRender {
        return ErrorSectionRender(
            buttonText = stringResource(R.string.buttonRetryLoadUserInfoText),
            errorTexts = listOf(stringResource(R.string.errorMessagingText)),
            iconRefreshDescription = stringResource(R.string.buttonRetryLoadUserInfoIconDescription)
        )
    }
}