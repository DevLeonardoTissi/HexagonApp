package br.com.leonardo.hexagonapp.ui.screens.form.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormViewModel
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
        }

    fun Module.personalProfileFormScreen() {
        registerScreenNavigation { PersonalProfileFormScreenNavigator() }
        viewModel { params ->
            PersonalProfileFormViewModel(
                insertProfileUseCase = get<InsertProfileUseCase>(),
                getProfileByIdUseCase = get<GetProfileByIdUseCase>(),
                id = params.getOrNull(),
            )
        }
    }
}
