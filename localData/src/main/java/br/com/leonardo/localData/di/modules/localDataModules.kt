package br.com.leonardo.localData.di.modules

import android.content.Context
import androidx.room.Room
import br.com.leonardo.localData.database.AppDatabase
import br.com.leonardo.localData.database.DatabaseSettingsCallback
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.SettingsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private const val DATABASE_NAME = "hexagonApp.db"

val localDataRepositoryModule = module {
    single {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).addCallback(DatabaseSettingsCallback()).build()
    }

    single { get<AppDatabase>().personalProfileDao }
    single { get<AppDatabase>().settingsDao }

    singleOf(::SettingsRepository)
    singleOf(::PersonalProfileRepository)
}
