package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response

import com.google.gson.annotations.SerializedName

data class GitHubProfileInfoResponseEntity(
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    val name: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val bio: String? = null,
    @SerializedName("public_repos") val publicRepos: Int? = null,
)
