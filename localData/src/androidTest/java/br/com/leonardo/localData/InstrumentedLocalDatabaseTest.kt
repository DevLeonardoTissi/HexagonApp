package br.com.leonardo.localData

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.SettingsRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
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

    //caso nao queira, nao precisa criar essa rule
    //Para modulos dinamicos
    @get:Rule
    val koinTestRule = KoinTestRuleTest(listOf(localDataRepositoryModuleTest))

    @Test
    fun test_a_searchDefaultSettings() =
        runBlocking {
            val repository by inject<SettingsRepository>()
            assertEquals(false, repository.searchSettings().first().darkMode)
        }

    @Test
    fun test_b_verifySettingsAfterChanges() = runBlocking {
        val repository by inject<SettingsRepository>()
        repository.updateSettings(Settings(1, true))

        val currentSettings = repository.searchSettings()
        assertEquals(true, currentSettings.first().darkMode)
    }

    @Test
    fun test_c_verifyCreatedUser() = runBlocking {
        val repository by inject<PersonalProfileRepository>()
        repository.insert(PersonalProfile(cpf = "123", name = "Test", city = "CityTest", active = true, dateOfBirth = "Today"))

        val currentSettings = repository.getActives()
        assertEquals("Test", currentSettings.first().first().name)
    }




}