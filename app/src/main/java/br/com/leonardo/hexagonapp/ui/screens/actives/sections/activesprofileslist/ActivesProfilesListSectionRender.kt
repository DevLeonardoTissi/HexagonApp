package br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.content.layout.section.HexagonSectionRender

data class ActivesProfilesListSectionRender(
    val activesProfilesList: List<PersonalProfile>
) : HexagonSectionRender
