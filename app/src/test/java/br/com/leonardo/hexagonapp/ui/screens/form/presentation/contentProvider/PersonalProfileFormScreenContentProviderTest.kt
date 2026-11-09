package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenBottomContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenContentContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider.PersonalProfileFormScreenContentProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PersonalProfileFormScreenContentProviderTest {
    private lateinit var personalProfileFormScreenContentProvider: PersonalProfileFormScreenContentProvider

    @Before
    fun setUp() {
        personalProfileFormScreenContentProvider = PersonalProfileFormScreenContentProvider()
    }

    @Test
    fun `must return corrects contents type`() {
        Assert.assertTrue(
            personalProfileFormScreenContentProvider.contentContent is PersonalProfileFormScreenContentContentProvider,
        )
        Assert.assertTrue(
            personalProfileFormScreenContentProvider.bottomContent is PersonalProfileFormScreenBottomContentProvider,
        )
    }
}
