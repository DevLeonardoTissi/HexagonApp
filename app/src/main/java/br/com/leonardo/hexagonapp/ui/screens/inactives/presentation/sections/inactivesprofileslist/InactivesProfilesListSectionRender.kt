package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.localData.model.PersonalProfile

data class InactivesProfilesListSectionRender(
    val inactivesProfilesList: List<PersonalProfile>,
) : HexagonSectionRender
