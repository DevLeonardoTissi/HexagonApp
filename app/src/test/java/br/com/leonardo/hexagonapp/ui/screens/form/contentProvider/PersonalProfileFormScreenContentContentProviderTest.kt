package br.com.leonardo.hexagonapp.ui.screens.form.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.sections.form.FormSection
import br.com.leonardo.hexagonapp.ui.screens.form.sections.userPhotoPicker.UserPhotoPickerSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PersonalProfileFormScreenContentContentProviderTest {

    private lateinit var personalProfileFormScreenContentContentProvider: PersonalProfileFormScreenContentContentProvider

    @Before
    fun setUp() {
        personalProfileFormScreenContentContentProvider =
            PersonalProfileFormScreenContentContentProvider()
    }

    @Test
    fun `must return corrects sections`() {
        val expectedTypes = listOf(
            UserPhotoPickerSection::class,
            FormSection::class
        )
        val result = personalProfileFormScreenContentContentProvider.getContent(
            PersonalProfileFormState(), PersonalProfileFormUIState()
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }
}