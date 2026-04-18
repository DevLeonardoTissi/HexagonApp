package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.utils.DevProfileScreenState
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.usecase.GetUserProfileInfoUseCase
import br.com.leonardo.webClient.usecase.GetUserRepositoriesInfoUseCase

class DevProfileViewModel(
    private val getUserProfileInfoUseCase: GetUserProfileInfoUseCase,
    private val getUserRepositoriesInfoUseCase: GetUserRepositoriesInfoUseCase,
) : HexagonViewModel<
        DevProfileActions,
        DevProfileState,
        DevProfileData,
        DevProfileUIState,
        DevProfileUIData
        >() {

    override val data = DevProfileData(
        initialState = DevProfileState()
    )

    override val uiData = DevProfileUIData(
        initialState = DevProfileUIState(screenState = DevProfileScreenState.Loading)
    )

    override fun handleAction(action: DevProfileActions) {
        when (action) {
            is DevProfileActions.ChangeVisibilityBottomSheetShare -> setVisibilityBottomSheetShareProfile(
                action.visibility
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
        uiData.updateUIState { it.copy(showBottomSheetShareProfile = show) }
    }

    fun loadUserInfo(isRefreshing: Boolean? = false) {
        if (isRefreshing == true) uiData.refresh(true) else uiData.load()
        getUserInfo()
    }

    private fun getUserInfo(
    ) {
        executeBlock(
            block = getUserProfileInfoUseCase::invoke,
            onSuccess = { userProfile ->
                onSuccessGetUserInfo(userProfile)
            }, onError = {
                onErrorGetUserInfo()
            })
    }

    private fun onSuccessGetUserInfo(userInfo: GitHubProfileInfoModel) {
        data.updateUserProfile(userInfo)
        getUserRepositories()
    }

    private fun onErrorGetUserInfo() {
        uiData.error()
    }

    private fun getUserRepositories(
    ) {
        executeBlock(
            block = getUserRepositoriesInfoUseCase::invoke,
            onSuccess = { userRepositories ->
                onSuccessGetUserRepositories(userRepositories)
            },
            onError = {
                onErrorGetUserRepositories()
            })
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