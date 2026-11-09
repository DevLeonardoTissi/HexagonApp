package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.localData.model.PersonalProfile

data class ActivesProfilesListSectionRender(
    val activesProfilesList: List<PersonalProfile>,
) : HexagonSectionRender
