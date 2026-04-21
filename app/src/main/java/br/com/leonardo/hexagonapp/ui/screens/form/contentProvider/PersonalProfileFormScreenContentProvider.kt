package br.com.leonardo.hexagonapp.ui.screens.form.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.content.provider.HexagonScaffoldContentProvider

class PersonalProfileFormScreenContentProvider(
    override val contentContent: HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>? = PersonalProfileFormScreenContentContentProvider(),
    override val bottomContent: HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>? = PersonalProfileFormScreenBottomContentProvider()
) : HexagonScaffoldContentProvider<PersonalProfileFormState, PersonalProfileFormUIState>()