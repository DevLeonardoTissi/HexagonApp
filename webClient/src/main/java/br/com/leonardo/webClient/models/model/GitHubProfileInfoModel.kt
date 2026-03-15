package br.com.leonardo.webClient.models.model

import androidx.compose.runtime.Stable

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