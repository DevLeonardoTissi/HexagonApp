package br.com.leonardo.webClient.model

import com.google.gson.annotations.SerializedName

class GitHubProfileInfoResponse(
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("html_url") val htmlUrl: String?,
    val name: String?,
    val blog: String?,
    val location: String?,
    val bio: String?,
    @SerializedName("public_repos") val publicRepos: Int?
)