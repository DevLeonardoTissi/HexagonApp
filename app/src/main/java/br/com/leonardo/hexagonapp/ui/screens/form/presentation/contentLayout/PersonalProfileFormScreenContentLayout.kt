package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.layout.content.scaffold.HexagonScaffoldContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class PersonalProfileFormScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<PersonalProfileFormState, PersonalProfileFormUIState>? =
        PersonalProfileFormScreenContentContentLayout(),
    override val bottomLayout: HexagonBaseContentLayout<PersonalProfileFormState, PersonalProfileFormUIState>? =
        PersonalProfileFormScreenBottomContentLayout(),
) : HexagonScaffoldContentLayout<PersonalProfileFormState, PersonalProfileFormUIState>() {
    @Composable
    override fun Modifier.bottomModifier(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
    ) = this.padding(10.dp)

    @Composable
    override fun Modifier.contentModifier(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
        innerPadding: PaddingValues,
    ): Modifier =
        this
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
}
