package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout

import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout.PersonalProfileFormScreenBottomContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout.PersonalProfileFormScreenContentContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentLayout.PersonalProfileFormScreenContentLayout
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PersonalProfileFormScreenContentLayoutTest {
    private lateinit var personalProfileFormScreenContentLayout: PersonalProfileFormScreenContentLayout

    @Before
    fun setUp() {
        personalProfileFormScreenContentLayout = PersonalProfileFormScreenContentLayout()
    }

    @Test
    fun `must return corrects contents layout type`() {
        Assert.assertTrue(
            personalProfileFormScreenContentLayout.contentLayout is PersonalProfileFormScreenContentContentLayout,
        )
        Assert.assertTrue(
            personalProfileFormScreenContentLayout.bottomLayout is PersonalProfileFormScreenBottomContentLayout,
        )
    }
}
