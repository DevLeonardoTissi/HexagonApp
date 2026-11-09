package br.com.leonardo.hexagonapp.ui

import androidx.compose.material3.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isRoot
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.main.presentation.MainActivity
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate

class FormScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    val composeTestRuleActivity = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldAllowUserToFillAndSubmitFormSuccessfully() {
        composeTestRule.setContent {
            HexagonAppTheme {
                Surface {
                    PersonalProfileFormScreen().Content()
                }
            }
        }

        val inputName = hasText("Digite seu nome") and hasClickAction()
        val inputCPF = hasText("Digite seu CPF") and hasClickAction()
        val inputCity = hasText("Digite sua cidade") and hasClickAction()
        val inputDateOfBirth = hasText("Data de nascimento") and hasClickAction()

        val datePickerDate =
            with(DateInDatePicker) {
                hasText("Today, $dayOfWeek, $monthName $day, $year") and hasClickAction()
            }
        val selectedDate =
            with(DateInDatePicker) {
                hasText("$day/$month/$year", substring = true)
            }
        val saveButton = hasContentDescription("Save button") and hasClickAction()
        val activeSwitch = hasContentDescription("Active switch") and hasClickAction()

        composeTestRule
            .onNode(inputName)
            .performClick()
            .performTextInput("Leo")

        composeTestRule
            .onNode(inputCPF)
            .performClick()
            .performTextInput("12345678900")

        composeTestRule
            .onNode(inputCity)
            .performClick()
            .performTextInput("Pirapetinga")

        composeTestRule
            .onNode(inputDateOfBirth)
            .performClick()

        composeTestRule.onAllNodes(isRoot())[1].printToLog("ESTRUTURA_DATEPICKER")
        composeTestRule
            .onNode(datePickerDate)
            .performClick()

        composeTestRule.onNodeWithText("Selecionar data").performClick()

        composeTestRule.onAllNodes(isRoot())[0].printToLog("ESTRUTURA_TELA")
        composeTestRule
            .onNode(selectedDate)
            .assertIsDisplayed()

        composeTestRule
            .onNode(activeSwitch)
            .performClick()

        composeTestRule
            .onNode(saveButton)
            .performClick()

        composeTestRule
            .onNodeWithText("Confirma a adição?")
            .assertIsDisplayed()
    }
}

object DateInDatePicker {
    val today: LocalDate = LocalDate.now()
    val dayOfWeek =
        today.dayOfWeek.name
            .lowercase()
            .replaceFirstChar { it.uppercase() }
    val month = today.monthValue.toString().padStart(2, '0')
    val day = today.dayOfMonth
    val year = today.year
    val monthName =
        today.month.name
            .lowercase()
            .replaceFirstChar { it.uppercase() }
}
