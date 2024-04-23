package br.com.leonardo.hexagonapp.di.modules

import android.content.Context
import androidx.room.Room
import br.com.leonardo.hexagonapp.database.AppDatabase
import br.com.leonardo.hexagonapp.database.dao.PersonalProfileDao
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DATABASE_NAME = "hexagonApp.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().personalProfileDao }
}

val repositoryModule = module {
    single { PersonalProfileRepository(get<PersonalProfileDao>()) }
}

val viewModelModule = module {
    viewModel  { HomeScreenViewModel(get<PersonalProfileRepository>()) }
}