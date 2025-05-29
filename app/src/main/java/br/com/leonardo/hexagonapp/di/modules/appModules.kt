package br.com.leonardo.hexagonapp.di.modules

import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::PersonalProfileFormViewModel)
    viewModelOf(::InactiveProfilesViewModel)
    viewModelOf(::AppViewModel)
    viewModelOf(::DevProfileViewModel)

}