package br.com.leonardo.hexagonapp.ui.screens.form.contentLayout

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.layout.content.HexagonColumnContentLayout
import androidx.compose.ui.Alignment

class PersonalProfileFormScreenBottomContentLayout: HexagonColumnContentLayout<PersonalProfileFormState, PersonalProfileFormUIState>(
    horizontalAlignment = Alignment.CenterHorizontally
)