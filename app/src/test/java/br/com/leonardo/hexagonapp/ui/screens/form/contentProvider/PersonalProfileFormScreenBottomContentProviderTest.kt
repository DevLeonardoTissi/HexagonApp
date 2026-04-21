package br.com.leonardo.hexagonapp.ui.screens.form.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.sections.confirmButton.ConfirmButtonSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PersonalProfileFormScreenBottomContentProviderTest {

    private lateinit var personalProfileFormScreenBottomContentProvider: PersonalProfileFormScreenBottomContentProvider

    @Before
    fun setUp() {
        personalProfileFormScreenBottomContentProvider =
            PersonalProfileFormScreenBottomContentProvider()
    }

    @Test
    fun `must return corrects sections`() {
        val expectedTypes = listOf(
            ConfirmButtonSection::class
        )
        val result = personalProfileFormScreenBottomContentProvider.getContent(
            PersonalProfileFormState(), PersonalProfileFormUIState()
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}