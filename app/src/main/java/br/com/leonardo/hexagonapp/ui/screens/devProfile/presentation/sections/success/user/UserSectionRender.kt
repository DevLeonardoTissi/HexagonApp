package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel

data class UserSectionRender(
    val userProfile : GitHubProfileInfoModel? = null,
    val shareIconDescription : String,
    val userImageDescription: String
): HexagonSectionRender
