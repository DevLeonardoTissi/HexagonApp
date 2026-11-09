package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.user

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel

data class UserSectionRender(
    val userProfile: GitHubProfileInfoModel? = null,
    val shareIconDescription: String,
    val userImageDescription: String,
) : HexagonSectionRender
