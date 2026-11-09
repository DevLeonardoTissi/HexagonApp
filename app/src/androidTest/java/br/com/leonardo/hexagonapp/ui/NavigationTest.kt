package br.com.leonardo.hexagonapp.ui

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import br.com.leonardo.appcore.presentation.navigator.HexagonNavigator
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.route.HomeRoute
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainScreen
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainScreenState
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainScreenUiState
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val controller = HexagonNavigator(startDestination = HomeRoute)

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            val appUiState = MainScreenUiState(currentRoute = HomeRoute)
            val appState = MainScreenState()

            HexagonAppTheme(darkTheme = appUiState.isDarkMode) {
                MainScreen(
                    appUiState = appUiState,
                    appState = appState,
                    onActions = {},
                )
            }
        }
    }

    @Test
    fun verifyStartDestination() {
        assert(controller.startDestination == HomeRoute)
    }

    @Test
    fun navigateToForm() {
        composeTestRule
            .onNode(hasContentDescription("add button to form screen") and hasClickAction())
            .performClick()
    }

    @Test
    fun navigateToInactive() {
        composeTestRule
            .onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule
            .onNode(hasContentDescription("Inactive Screen") and hasClickAction())
            .performClick()
    }

    @Test
    fun navigateToFormDrawer() {
        composeTestRule
            .onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule
            .onNode(hasContentDescription("Form Screen") and hasClickAction())
            .performClick()
    }

    @Test
    fun navigateToHomeDrawer() {
        composeTestRule
            .onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule
            .onNode(hasContentDescription("Home Screen") and hasClickAction())
            .performClick()
    }

    @Test
    fun navigateToDevProfile() {
        composeTestRule
            .onNode(hasContentDescription("Open drawer") and hasClickAction())
            .performClick()
        composeTestRule
            .onNode(hasContentDescription("Dev Profile Screen") and hasClickAction())
            .performClick()
    }
}
