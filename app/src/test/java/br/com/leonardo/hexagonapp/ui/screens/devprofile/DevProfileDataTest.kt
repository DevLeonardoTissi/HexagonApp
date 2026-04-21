package br.com.leonardo.hexagonapp.ui.screens.devprofile

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileData
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DevProfileDataTest {
    private lateinit var devProfileData: DevProfileData
    private val initialState = DevProfileState()

    @Before
    fun setUp() {
        devProfileData = DevProfileData(initialState)
    }

    @Test
    fun `must return correct initial state when create object`() {
        Assert.assertEquals(
            devProfileData.getState().userProfile,
            initialState.userProfile
        )
        Assert.assertEquals(
            devProfileData.getState().repositories,
            initialState.repositories
        )
    }

    @Test
    fun `must return correct userProfile after call updateUserProfile function`() {
        val userProfile = GitHubProfileInfoModel(
            avatarUrl = "https://avatar.url",
            htmlUrl = "https://github.com/user",
            name = "Leonardo",
            blog = "https://blog.com",
            location = "Brazil",
            bio = "Android Developer",
            publicRepos = 10
        )

        devProfileData.updateUserProfile(userProfile)

        Assert.assertEquals(devProfileData.getState().userProfile, userProfile)
    }

    @Test
    fun `must return correct repositories after call updateUserRepositories function`() {
        val repositories = listOf(
            GithubRepositoryInfoModel(
                name = "Repo 1",
                htmlUrl = "https://github.com/repo1",
                description = "Description 1"
            ),
            GithubRepositoryInfoModel(
                name = "Repo 2",
                htmlUrl = "https://github.com/repo2",
                description = "Description 2"
            )
        )

        devProfileData.updateUserRepositories(repositories)

        Assert.assertEquals(devProfileData.getState().repositories, repositories)
    }
}