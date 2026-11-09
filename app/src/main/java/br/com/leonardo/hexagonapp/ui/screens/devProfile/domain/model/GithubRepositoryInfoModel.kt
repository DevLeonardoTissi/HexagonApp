package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model

import androidx.compose.runtime.Stable

/**
 * Domain model representing GitHub repository information.
 *
 * @property name Repository name.
 * @property htmlUrl Repository GitHub webpage URL.
 * @property description Repository description text.
 */
@Stable
data class GithubRepositoryInfoModel(
    val name: String,
    val htmlUrl: String,
    val description: String,
)
