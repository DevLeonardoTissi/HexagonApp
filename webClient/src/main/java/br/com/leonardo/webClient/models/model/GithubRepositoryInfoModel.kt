package br.com.leonardo.webClient.models.model

import androidx.compose.runtime.Stable

@Stable
data class GithubRepositoryInfoModel(
    val name: String,
    val htmlUrl: String,
    val description: String
)