package br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.domain

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserProfileInfoUseCase
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserRepositoriesInfoUseCase
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.impl.GetUserProfileInfoUseCaseImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.impl.GetUserRepositoriesInfoUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class DevProfileDomainDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            factoryOf(::GetUserProfileInfoUseCaseImpl) { bind<GetUserProfileInfoUseCase>() }
            factoryOf(::GetUserRepositoriesInfoUseCaseImpl) { bind<GetUserRepositoriesInfoUseCase>() }
        }
}
