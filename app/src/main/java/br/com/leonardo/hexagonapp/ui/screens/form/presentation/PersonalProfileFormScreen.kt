package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout.PersonalProfileFormScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.route.FormRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

/** Main screen composable for creating or editing personal profile forms. */
class PersonalProfileFormScreen :
    HexagonScreen<
        FormRoute,
        PersonalProfileFormState,
        PersonalProfileFormUIState,
        PersonalProfileFormViewModel,
        PersonalProfileFormScreenContentLayout,
        PersonalProfileFormScreenContentProvider,
    >() {
    @Composable
    override fun provideViewModel(arguments: FormRoute?): PersonalProfileFormViewModel {
        val id = arguments?.profileId
        return koinViewModel<PersonalProfileFormViewModel> {
            parametersOf(id)
        }
    }

    override val provideContentLayout: PersonalProfileFormScreenContentLayout =
        PersonalProfileFormScreenContentLayout()
    override val provideContentProvider: PersonalProfileFormScreenContentProvider =
        PersonalProfileFormScreenContentProvider()
}
