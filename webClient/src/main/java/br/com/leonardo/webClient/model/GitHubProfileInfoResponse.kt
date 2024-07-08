package br.com.leonardo.webClient.model

class GitHubProfileInfoResponse(
    private val avatar_url: String?,
    private val html_url: String?,
    private val name: String?,
    private val blog: String?,
    private val location: String?,
    private val bio: String?,
    private val public_repos: Int?
) {
    val gitHubProfileInfo: GitHubProfileInfo
        get() = GitHubProfileInfo(
            avatar_url,
            html_url,
            name,
            blog,
            location,
            bio,
            public_repos
        )
}