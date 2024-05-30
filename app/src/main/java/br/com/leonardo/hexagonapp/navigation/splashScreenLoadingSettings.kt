package br.com.leonardo.hexagonapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.splashScreenLoadingSettings.SplashScreenLoadingSettings

internal const val splashScreenRoute = "splashScreen"

fun NavGraphBuilder.splashScreen(){
    composable(splashScreenRoute){
        SplashScreenLoadingSettings()
    }
}

fun NavController.navigateToSplashScreen(navOptions: NavOptions? = null){
    navigate(splashScreenRoute, navOptions)
}