package br.com.leonardo.hexagonapp.di.modules

import android.content.Context
import androidx.room.Room
import br.com.leonardo.hexagonapp.database.AppDatabase
import br.com.leonardo.hexagonapp.database.DatabaseSettingsCallback
import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.database.dao.SettingsDAO
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import br.com.leonardo.hexagonapp.repository.SettingsRepository
import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DATABASE_NAME = "hexagonApp.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).addCallback(DatabaseSettingsCallback()).build()
    }

    single { get<AppDatabase>().personalProfileDao }
    single { get<AppDatabase>().settingsDao }
}

val repositoryModule = module {
    single { PersonalProfileRepository(get<PersonalProfileDao>()) }
    single { SettingsRepository(get<SettingsDAO>()) }
}

val viewModelModule = module {
    viewModel { HomeScreenViewModel(get<PersonalProfileRepository>()) }
    viewModel { PersonalProfileFormViewModel(get<PersonalProfileRepository>()) }
    viewModel { InactiveProfilesViewModel(get<PersonalProfileRepository>()) }
    viewModel { AppViewModel(get<SettingsRepository>()) }
}