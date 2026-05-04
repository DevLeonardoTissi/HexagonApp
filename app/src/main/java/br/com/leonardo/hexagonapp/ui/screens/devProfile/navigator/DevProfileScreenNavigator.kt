package br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.navigation3.ui.NavDisplay
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.route.DevProfileScreenRoute
import br.com.leonardo.ui.navigator.ScreenNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

class DevProfileScreenNavigator : ScreenNavigator<DevProfileScreenRoute, DevProfileScreen> {

    override val screen = DevProfileScreen()

    @OptIn(KoinExperimentalAPI::class)
    override fun registerNavigationModule(): Module = module {
        navigation<DevProfileScreenRoute>(
            metadata = NavDisplay.transitionSpec {
                slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = tween(1000)
                ) togetherWith ExitTransition.KeepUntilTransitionsFinished
            } + NavDisplay.popTransitionSpec {
                EnterTransition.None togetherWith slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(1000)
                )
            } + NavDisplay.predictivePopTransitionSpec {
                EnterTransition.None togetherWith slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(1000)
                )
            }
        ) { arguments ->
            screen.Content(arguments = arguments)
        }
    }
}