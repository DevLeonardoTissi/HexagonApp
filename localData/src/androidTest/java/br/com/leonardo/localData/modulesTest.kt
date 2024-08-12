package br.com.leonardo.localData

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import br.com.leonardo.localData.database.AppDatabase
import br.com.leonardo.localData.database.DatabaseSettingsCallback
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.PersonalProfileRepositoryImpl
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.localData.repository.SettingsRepositoryImpl
import org.koin.dsl.module


val localDataRepositoryModuleTest = module {
    single {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Room.inMemoryDatabaseBuilder(
            appContext,
            AppDatabase::class.java
        ).addCallback(DatabaseSettingsCallback()).allowMainThreadQueries().build()
    }

    single { get<AppDatabase>().personalProfileDao }
    single { get<AppDatabase>().settingsDao }
    single<PersonalProfileRepository> { PersonalProfileRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}