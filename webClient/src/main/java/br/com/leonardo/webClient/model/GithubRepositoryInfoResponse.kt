package br.com.leonardo.webClient.model

import com.google.gson.annotations.SerializedName

class GithubRepositoryInfoResponse(
    val name: String?,
    @SerializedName("html_url") val htmlUrl: String?,
    val description: String?,
)