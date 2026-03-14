package br.com.leonardo.hexagonapp.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isRoot
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import br.com.leonardo.hexagonapp.ui.activity.MainActivity
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUiState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class FormScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    //corrigir Classe porteriormente
    val composeTestRuleActivity = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldAllowUserToFillAndSubmitFormSuccessfully() {
        composeTestRule.setContent {
            val viewModel: PersonalProfileFormViewModel =
                koinViewModel<PersonalProfileFormViewModel>(
                    parameters = { parametersOf(null) }
                )
            val uiState: PersonalProfileFormUiState by viewModel.uiState.collectAsState()
            HexagonAppTheme {
                Surface {
                    PersonalProfileFormScreen(
                        uiState = uiState
                    ) {
                        Unit
                    }
                }
            }
        }

        val inputName = hasText("Digite seu nome") and hasClickAction()
        val inputCPF = hasText("Digite seu CPF") and hasClickAction()
        val inputCity = hasText("Digite sua cidade") and hasClickAction()
        val inputDateOfBirth = hasText("Data de nascimento") and hasClickAction()
        val datePickerDate = hasText("Friday, March 13, 2026") and hasClickAction()
        val selectedDate = hasText("13/03/2026", substring = true)
        val saveButton = hasContentDescription("Save button") and hasClickAction()
        val activeSwitch = hasContentDescription("Active switch") and hasClickAction()

        composeTestRule.onNode(inputName)
            .performClick()
            .performTextInput("Leo")

        composeTestRule.onNode(inputCPF)
            .performClick().performTextInput("12345678900")

        composeTestRule.onNode(inputCity)
            .performClick()
            .performTextInput("Pirapetinga")

        composeTestRule.onNode(inputDateOfBirth)
            .performClick()

        composeTestRule.onNode(datePickerDate)
            .performClick()

        composeTestRule.onAllNodes(isRoot())[1].printToLog("ESTRUTURA_DATEPICKER")
        composeTestRule.onNodeWithText("Selecionar data").performClick()

        composeTestRule.onAllNodes(isRoot())[0].printToLog("ESTRUTURA_TELA")
        composeTestRule.onNode(selectedDate)
            .assertIsDisplayed()

        composeTestRule.onNode(activeSwitch)
            .performClick()

        composeTestRule.onNode(saveButton)
            .performClick()

        composeTestRule
            .onNodeWithText("Confirma a adição?")
            .assertIsDisplayed()

    }
}