package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenContentContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.form.FormSection
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.userPhotoPicker.UserPhotoPickerSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PersonalProfileFormScreenContentContentProviderTest {
    private lateinit var personalProfileFormScreenContentContentProvider:
        PersonalProfileFormScreenContentContentProvider

    @Before
    fun setUp() {
        personalProfileFormScreenContentContentProvider =
            PersonalProfileFormScreenContentContentProvider()
    }

    @Test
    fun `must return corrects sections`() {
        val expectedTypes =
            listOf(
                UserPhotoPickerSection::class,
                FormSection::class,
            )
        val result =
            personalProfileFormScreenContentContentProvider
                .getContent(
                    PersonalProfileFormState(),
                    PersonalProfileFormUIState(),
                ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}
