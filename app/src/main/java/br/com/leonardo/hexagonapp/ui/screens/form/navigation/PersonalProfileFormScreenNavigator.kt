package br.com.leonardo.hexagonapp.ui.screens.form.navigation

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.navigation.route.FormRoute
import br.com.leonardo.ui.navigator.ScreenNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class PersonalProfileFormScreenNavigator : ScreenNavigator<FormRoute, PersonalProfileFormScreen> {

    override val screen = PersonalProfileFormScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module {
        return module {
            navigation<FormRoute>{ formRoute ->
                screen.Content(arguments = formRoute)
            }
        }
    }
}