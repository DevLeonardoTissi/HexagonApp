package br.com.leonardo.localData


import android.content.Context
import androidx.room.Room
import br.com.leonardo.localData.database.AppDatabase
import br.com.leonardo.localData.database.DatabaseSettingsCallback
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.SettingsRepository
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocalDatabaseTest  : KoinTest{

    private val localDataRepositoryModule = module {
        single {
            Room.inMemoryDatabaseBuilder(
                mockk<Context>(),
                AppDatabase::class.java
            ).addCallback(DatabaseSettingsCallback()).build()
        }

        single { get<AppDatabase>().personalProfileDao }
        single { get<AppDatabase>().settingsDao }

        singleOf(::SettingsRepository)
        singleOf(::PersonalProfileRepository)
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(localDataRepositoryModule)
    }

    @Test
    fun `must return true because the initial settings were set when creating the database`() = runTest{
        val repository by inject <SettingsRepository>()
        assertNotNull(repository.searchSettings())
    }

    @Test
    fun `muust return true`() = runTest{
        val repository by inject <SettingsRepository>()
        repository.updateSettings(Settings(1,true))

        val currentSettings = repository.searchSettings()
        assertEquals(true, currentSettings.first().darkMode)
    }



}