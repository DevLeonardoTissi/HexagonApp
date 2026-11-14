package br.com.leonardo.hexagonapp.ui.screens.form.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.di.contentLayoutOf
import br.com.leonardo.appcore.presentation.di.contentProviderOf
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout.PersonalProfileFormScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.PersonalProfileFormScreenNavigator
import br.com.leonardo.localData.usecase.GetProfileByIdUseCase
import br.com.leonardo.localData.usecase.InsertProfileUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class PersonalProfileFormPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            personalProfileFormScreen()
            personalProfileFormScreenNavigator()
        }

    fun Module.personalProfileFormScreen() {
        scope<PersonalProfileFormScreen> {
            contentLayoutOf<
                PersonalProfileFormState,
                PersonalProfileFormUIState,
                PersonalProfileFormScreenContentLayout,
            >()
            contentProviderOf<
                PersonalProfileFormState,
                PersonalProfileFormUIState,
                PersonalProfileFormScreenContentProvider,
            >()
            viewModel { params ->
                PersonalProfileFormViewModel(
                    insertProfileUseCase = get<InsertProfileUseCase>(),
                    getProfileByIdUseCase = get<GetProfileByIdUseCase>(),
                    id = params.getOrNull(),
                )
            }
        }
    }

    fun Module.personalProfileFormScreenNavigator() {
        registerScreenNavigation { PersonalProfileFormScreenNavigator() }
    }
}
