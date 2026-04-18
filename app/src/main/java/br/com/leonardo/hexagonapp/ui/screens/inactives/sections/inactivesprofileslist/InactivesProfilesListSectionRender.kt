package br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.content.layout.section.HexagonSectionRender

data class InactivesProfilesListSectionRender(
    val inactivesProfilesList: List<PersonalProfile>
) : HexagonSectionRender
