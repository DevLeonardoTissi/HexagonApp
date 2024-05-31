package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.model.GitHubProfileInfo

data class DevProfileUiState (
    val userProfile : GitHubProfileInfo = GitHubProfileInfo(),
    val loadingInfo : Boolean = true,
){
}
