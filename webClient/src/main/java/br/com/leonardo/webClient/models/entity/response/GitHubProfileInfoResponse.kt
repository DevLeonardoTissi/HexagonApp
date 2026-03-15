package br.com.leonardo.webClient.models.entity.response

import com.google.gson.annotations.SerializedName

data class GitHubProfileInfoResponse(
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    val name: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val bio: String? = null,
    @SerializedName("public_repos") val publicRepos: Int? = null
)