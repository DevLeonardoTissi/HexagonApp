package br.com.leonardo.localData

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import br.com.leonardo.localData.database.AppDatabase
import br.com.leonardo.localData.database.DatabaseSettingsCallback
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.repository.impl.PersonalProfileRepositoryImpl
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.localData.repository.impl.SettingsRepositoryImpl
import br.com.leonardo.localData.source.local.PersonalProfileLocalSource
import br.com.leonardo.localData.source.local.SettingsLocalSource
import br.com.leonardo.localData.source.local.impl.PersonalProfileLocalSourceImpl
import br.com.leonardo.localData.source.local.impl.SettingsLocalSourceImpl
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetActivesProfilesUseCase
import br.com.leonardo.localData.usecase.GetInactivesProfilesUseCase
import br.com.leonardo.localData.usecase.GetProfileByIdUseCase
import br.com.leonardo.localData.usecase.InsertProfileUseCase
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase
import br.com.leonardo.localData.usecase.impl.DeleteProfileUseCaseImpl
import br.com.leonardo.localData.usecase.impl.GetActivesProfilesUseCaseImpl
import br.com.leonardo.localData.usecase.impl.GetInactivesProfilesUseCaseImpl
import br.com.leonardo.localData.usecase.impl.GetProfileByIdUseCaseImpl
import br.com.leonardo.localData.usecase.impl.InsertProfileUseCaseImpl
import br.com.leonardo.localData.usecase.impl.SearchSettingsUseCaseImpl
import br.com.leonardo.localData.usecase.impl.UpdateSettingsUseCaseImpl
import org.koin.dsl.module


val localDataModuleTest = module {
    single {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Room.inMemoryDatabaseBuilder(
            appContext,
            AppDatabase::class.java
        ).addCallback(DatabaseSettingsCallback()).allowMainThreadQueries().build()
    }

    single { get<AppDatabase>().personalProfileDao }
    single { get<AppDatabase>().settingsDao }
    single<PersonalProfileLocalSource> { PersonalProfileLocalSourceImpl(get()) }
    single<PersonalProfileRepository> { PersonalProfileRepositoryImpl(get()) }
    single<GetActivesProfilesUseCase> { GetActivesProfilesUseCaseImpl(get()) }
    single<GetInactivesProfilesUseCase> { GetInactivesProfilesUseCaseImpl(get()) }
    single<GetProfileByIdUseCase> { GetProfileByIdUseCaseImpl(get()) }
    single<DeleteProfileUseCase> { DeleteProfileUseCaseImpl(get()) }
    single<InsertProfileUseCase> { InsertProfileUseCaseImpl(get()) }
    single<SettingsLocalSource> { SettingsLocalSourceImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
    single<SearchSettingsUseCase> { SearchSettingsUseCaseImpl(get()) }
    single<UpdateSettingsUseCase> { UpdateSettingsUseCaseImpl(get()) }
}