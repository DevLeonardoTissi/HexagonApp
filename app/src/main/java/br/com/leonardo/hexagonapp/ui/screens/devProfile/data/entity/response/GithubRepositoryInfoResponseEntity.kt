package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response

import com.google.gson.annotations.SerializedName

data class GithubRepositoryInfoResponseEntity(
    val name: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    val description: String? = null,
)
