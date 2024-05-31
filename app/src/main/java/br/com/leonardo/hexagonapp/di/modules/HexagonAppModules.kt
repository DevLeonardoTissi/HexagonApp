package br.com.leonardo.hexagonapp.di.modules

import android.content.Context
import androidx.room.Room
import br.com.leonardo.hexagonapp.database.AppDatabase
import br.com.leonardo.hexagonapp.database.DatabaseSettingsCallback
import br.com.leonardo.hexagonapp.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import br.com.leonardo.hexagonapp.repository.SettingsRepository
import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import br.com.leonardo.hexagonapp.webClient.services.GithubApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DATABASE_NAME = "hexagonApp.db"
private const val GITHUB_API_BASE_URL = "https://api.github.com/users/"

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

val retrofitModule = module {

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    single {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single { get<Retrofit>().create(GithubApiService::class.java) }
}

val repositoryModule = module {
    singleOf(::PersonalProfileRepository)
    singleOf(::SettingsRepository)
    singleOf(::GithubUserRepository)
}

val viewModelModule = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::PersonalProfileFormViewModel)
    viewModelOf(::InactiveProfilesViewModel)
    viewModelOf(::AppViewModel)
    viewModelOf(::DevProfileViewModel)

}