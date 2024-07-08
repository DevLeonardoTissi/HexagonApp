package br.com.leonardo.webClient.model

class GithubRepositoryInfoResponse(
    private val name: String?,
    private val html_url: String?,
    private val description: String?,
) {

    val gitHubRepositoryInfo: GithubRepositoryInfo
        get() = GithubRepositoryInfo(
            name = name,
            html_url = html_url,
            description = description
        )
}