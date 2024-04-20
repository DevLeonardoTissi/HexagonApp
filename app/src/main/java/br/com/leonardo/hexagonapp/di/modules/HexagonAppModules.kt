package br.com.leonardo.hexagonapp.di.modules

import androidx.room.Room
import br.com.leonardo.hexagonapp.database.AppDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "hexagonApp.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().personalProfileDao }
}