package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenBottomContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.confirmButton.ConfirmButtonSection
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
        val expectedTypes =
            listOf(
                ConfirmButtonSection::class,
            )
        val result =
            personalProfileFormScreenBottomContentProvider
                .getContent(
                    PersonalProfileFormState(),
                    PersonalProfileFormUIState(),
                ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}
