package br.com.leonardo.localData

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.SettingsRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class InstrumentedLocalDatabaseTest : KoinComponent {

    //If you don't want dynamic modules, you don't need to create this rule
    @get:Rule
    val koinTestRule = KoinTestRule(listOf(localDataRepositoryModuleTest))

    private val personalProfileRepository by inject<PersonalProfileRepository>()
    private val settingsRepository by inject<SettingsRepository>()

    @Test
    fun test_a_defaultSettingsShouldHaveDarkModeDisabled() =
        runBlocking {
            assertEquals(false, settingsRepository.searchSettings().first().darkMode)
        }

    @Test
    fun test_b_settingsShouldReflectChangesAfterUpdate() = runBlocking {
        settingsRepository.updateSettings(Settings(1, true))
        val currentSettings = settingsRepository.searchSettings()
        assertEquals(true, currentSettings.first().darkMode)
    }

    @Test
    fun test_c_userProfileShouldBeCorrectlyCreated() = runBlocking {
        personalProfileRepository.insert(
            PersonalProfile(
                cpf = "123",
                name = "Test",
                city = "CityTest",
                active = true,
                dateOfBirth = "Today"
            )
        )
        val currentSettings = personalProfileRepository.getActives()
        assertEquals("Test", currentSettings.first().first().name)
    }

    @Test
    fun test_d_userProfileShouldBeCorrectlyDeleted() = runBlocking {
        personalProfileRepository.remove(
            PersonalProfile(
                cpf = "123",
                name = "Test",
                city = "CityTest",
                active = true,
                dateOfBirth = "Today"
            )
        )

        val currentActivesProfiles = personalProfileRepository.getActives().first()
        assertTrue(currentActivesProfiles.isEmpty())
    }

    @Test
    fun test_e_userProfileInactiveShouldBeCorrectlyCreated() = runBlocking {
        personalProfileRepository.insert(
            PersonalProfile(
                cpf = "123",
                name = "TestInactive",
                city = "CityTest",
                active = false,
                dateOfBirth = "Today"
            )
        )
        val currentInactivesProfiles = personalProfileRepository.getInactive()
        assertEquals("TestInactive", currentInactivesProfiles.first().first().name)
    }


}