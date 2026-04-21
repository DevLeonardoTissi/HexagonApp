package br.com.leonardo.hexagonapp.ui.screens.form.contentProvider

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
            personalProfileFormScreenContentProvider.contentContent is PersonalProfileFormScreenContentContentProvider
        )
        Assert.assertTrue(
            personalProfileFormScreenContentProvider.bottomContent is PersonalProfileFormScreenBottomContentProvider
        )
    }
}