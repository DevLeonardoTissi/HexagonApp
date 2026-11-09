package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.viewmodel.HexagonViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserProfileInfoUseCase
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.usecase.GetUserRepositoriesInfoUseCase
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.model.DevProfileScreenState

/**
 * ViewModel managing state and network requests for the GitHub Developer Profile screen.
 *
 * @property getUserProfileInfoUseCase Use case for fetching GitHub user details.
 * @property getUserRepositoriesInfoUseCase Use case for fetching GitHub repositories.
 */
class DevProfileViewModel(
    private val getUserProfileInfoUseCase: GetUserProfileInfoUseCase,
    private val getUserRepositoriesInfoUseCase: GetUserRepositoriesInfoUseCase,
) : HexagonViewModel<
        DevProfileState,
        DevProfileData,
        DevProfileUIState,
        DevProfileUIData,
    >() {
    override val data =
        DevProfileData(
            initialState = DevProfileState(),
        )

    override val uiData =
        DevProfileUIData(
            initialState = DevProfileUIState(screenState = DevProfileScreenState.Loading),
        )

    override fun handleAction(action: HexagonAction) {
        when (action) {
            is DevProfileActions.ChangeVisibilityBottomSheetShare ->
                setVisibilityBottomSheetShareProfile(
                    action.visibility,
                )

            is DevProfileActions.Load -> loadUserInfo()
            is DevProfileActions.Refresh -> refreshingPerform()
        }
    }

    init {
        loadUserInfo()
    }

    private fun refreshingPerform() {
        loadUserInfo(isRefreshing = true)
    }

    private fun setVisibilityBottomSheetShareProfile(show: Boolean) {
        uiData.updateBottomSheetShareProfileVisibility(show)
    }

    fun loadUserInfo(isRefreshing: Boolean? = false) {
        if (isRefreshing == true) uiData.refresh(true) else uiData.load()
        getUserInfo()
    }

    private fun getUserInfo() {
        executeBlock(
            block = getUserProfileInfoUseCase::invoke,
            onSuccess = { userProfile ->
                onSuccessGetUserInfo(userProfile)
            },
            onError = {
                onErrorGetUserInfo()
            },
        )
    }

    private fun onSuccessGetUserInfo(userInfo: GitHubProfileInfoModel) {
        data.updateUserProfile(userInfo)
        getUserRepositories()
    }

    private fun onErrorGetUserInfo() {
        uiData.error()
        uiData.refresh(false)
    }

    private fun getUserRepositories() {
        executeBlock(
            block = getUserRepositoriesInfoUseCase::invoke,
            onSuccess = { userRepositories ->
                onSuccessGetUserRepositories(userRepositories)
            },
            onError = {
                onErrorGetUserRepositories()
            },
        )
    }

    private fun onSuccessGetUserRepositories(repositories: List<GithubRepositoryInfoModel>) {
        data.updateUserRepositories(repositories)
        uiData.refresh(false)
        uiData.success()
    }

    private fun onErrorGetUserRepositories() {
        uiData.error()
    }
}
