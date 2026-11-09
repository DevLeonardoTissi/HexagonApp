package br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation

import br.com.leonardo.appcore.presentation.navigator.ScreenNavigator
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.route.FormRoute
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class PersonalProfileFormScreenNavigator : ScreenNavigator<FormRoute, PersonalProfileFormScreen> {
    override val screen = PersonalProfileFormScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module =
        module {
            navigation<FormRoute> { arguments ->
                screen.Content(arguments = arguments)
            }
        }
}
