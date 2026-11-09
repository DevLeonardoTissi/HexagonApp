package br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model

import androidx.compose.runtime.Stable

/**
 * Domain model representing developer profile details.
 *
 * @property avatarUrl URL for profile avatar image.
 * @property htmlUrl GitHub profile webpage URL.
 * @property name Developer name.
 * @property blog Optional blog URL.
 * @property location Developer location.
 * @property bio Developer biography text.
 * @property publicRepos Total count of public repositories.
 */
@Stable
data class GitHubProfileInfoModel(
    val avatarUrl: String,
    val htmlUrl: String,
    val name: String,
    val blog: String,
    val location: String,
    val bio: String,
    val publicRepos: Int?,
)
