package br.com.leonardo.hexagonapp.ui.screens.devprofile.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.model.DevProfileScreenState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error.ErrorSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading.LoadSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories.RepositoriesSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user.UserSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DevProfileScreenContentProviderTest {

    private lateinit var devProfileScreenContentProvider: DevProfileScreenContentProvider

    @Before
    fun setUp() {
        devProfileScreenContentProvider = DevProfileScreenContentProvider()
    }

    @Test
    fun `must return corrects sections when load state`() {
        val expectedTypes = listOf(
            LoadSection::class
        )
        val result = devProfileScreenContentProvider.getContent(
            DevProfileState(), DevProfileUIState(
                screenState = DevProfileScreenState.Loading
            )
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }

    @Test
    fun `must return corrects sections when success state`() {
        val expectedTypes = listOf(
            UserSection::class,
            RepositoriesSection::class
        )
        val result = devProfileScreenContentProvider.getContent(
            DevProfileState(), DevProfileUIState(
                screenState = DevProfileScreenState.Success
            )
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }

    @Test
    fun `must return corrects sections when error state`() {
        val expectedTypes = listOf(
            ErrorSection::class
        )
        val result = devProfileScreenContentProvider.getContent(
            DevProfileState(), DevProfileUIState(
                screenState = DevProfileScreenState.Error
            )
        ).map { it::class }

        Assert.assertTrue(result.containsAll(expectedTypes))
    }

}