package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.content.provider.HexagonScaffoldContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class PersonalProfileFormScreenContentProvider(
    override val contentContent: HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>? =
        PersonalProfileFormScreenContentContentProvider(),
    override val bottomContent: HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>? =
        PersonalProfileFormScreenBottomContentProvider(),
) : HexagonScaffoldContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>()
