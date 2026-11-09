package br.com.leonardo.hexagonapp.ui.screens.form.lib

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.form.lib.presentation.PersonalProfileFormPresentationDiLibrary
import org.koin.dsl.module

class PersonalProfileFormScreenDiLibrary : HexagonLibrary {
    private val presentationLibrary = PersonalProfileFormPresentationDiLibrary()

    override fun getModules() =
        module {
            includes(presentationLibrary.getModules())
        }
}
