package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model

import androidx.compose.runtime.Stable

@Stable
data class GithubRepositoryInfoModel(
    val name: String,
    val htmlUrl: String,
    val description: String,
)
