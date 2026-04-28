package br.com.leonardo.hexagonapp.ui.screens.form.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.navigation.route.FormRoute
import br.com.leonardo.ui.navigator.ScreenNavigator

class PersonalProfileFormScreenNavigator : ScreenNavigator<FormRoute> {
    override val screen = PersonalProfileFormScreen()

    override val destination = FormRoute()

    override fun registerScreenNavigator(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<FormRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<FormRoute>()
            screen.Content(arguments = route)
        }
    }
}