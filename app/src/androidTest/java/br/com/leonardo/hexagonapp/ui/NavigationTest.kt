package br.com.leonardo.hexagonapp.ui

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.activity.MainScreen
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.compose.koinViewModel

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {

            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            val appViewModel: AppViewModel = koinViewModel()
            val appUiState by appViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()

            HexagonAppTheme(darkTheme = appUiState.isDarkMode) {
                MainScreen(
                    navController,
                    appUiState,
                    onCurrentRouteChange = { appUiState.onCurrentRouteChange(it) },
                    changeVisibilityBottomSheetConfigAndInfo = {
                        appUiState.changeVisibilityBottomSheetDialogInfoAndConfig(
                            it
                        )
                    },
                    onUpdateDarkMode = { appUiState.onDarkModeChange(it) },
                    onUpdateDrawerState = {
                        coroutineScope.launch {
                            appUiState.updateDrawer()
                        }
                    }
                )
            }
        }
    }

    @Test
    fun verifyStartDestination() {
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("HomeRoute")?.let { assert(it) }
    }

    @Test
    fun navigateToForm() {
        composeTestRule.onNode(hasContentDescription("add button to form screen") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("FormRoute")?.let { assert(it) }
    }


    private fun backToHome() {
        composeTestRule.onNode(hasContentDescription("navigate to back") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("HomeRoute")?.let { assert(it) }
    }

    @Test
    fun navigateToInactive() {
        composeTestRule.onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule.onNode(hasContentDescription("Inactive Screen") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("InactiveRoute")?.let { assert(it) }
    }

    @Test
    fun navigateToFormDrawer() {
        composeTestRule.onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule.onNode(hasContentDescription("Form Screen") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("FormRoute")?.let { assert(it) }
    }

    @Test
    fun navigateToHomeDrawer() {
        composeTestRule.onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule.onNode(hasContentDescription("Home Screen") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("HomeRoute")?.let { assert(it) }
    }

    @Test
    fun navigateToDevProfile() {
        composeTestRule.onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule.onNode(hasContentDescription("Dev Profile Screen") and hasClickAction())
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        route?.contains("DevProfileRoute")?.let { assert(it) }
    }


}