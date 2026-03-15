package br.com.leonardo.webClient.models.entity.response

import com.google.gson.annotations.SerializedName

data class GithubRepositoryInfoResponse(
    val name: String? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    val description: String? = null,
)