package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.form.contentLayout.PersonalProfileFormScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.contentProvider.PersonalProfileFormScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.navigation.route.FormRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class PersonalProfileFormScreen : HexagonScreen<
        FormRoute,
        PersonalProfileFormActions,
        PersonalProfileFormState,
        PersonalProfileFormUIState,
        PersonalProfileFormViewModel,
        PersonalProfileFormScreenContentLayout,
        PersonalProfileFormScreenContentProvider
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