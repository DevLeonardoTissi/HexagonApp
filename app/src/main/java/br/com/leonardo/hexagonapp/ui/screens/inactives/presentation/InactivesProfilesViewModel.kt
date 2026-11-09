package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import androidx.lifecycle.viewModelScope
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.action.HexagonNavigationAction
import br.com.leonardo.appcore.presentation.viewmodel.HexagonViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.route.FormRoute
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetInactivesProfilesUseCase
import br.com.leonardo.localData.usecase.UpdateProfileUseCase
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class InactivesProfilesViewModel(
    private val getInactivesProfilesUseCase: GetInactivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
) : HexagonViewModel<
        InactivesProfilesState,
        InactivesProfilesData,
        InactivesProfilesUiState,
        InactivesProfilesUiData,
    >() {
    override fun handleAction(action: HexagonAction) {
        when (action) {
            is InactivesProfilesActions.DeleteProfile -> remove(action.profile)
            is InactivesProfilesActions.UpdateProfile -> update(action.profile)
            is InactivesProfilesActions.ClickProfile -> navigateToEdit(action.profileId)
        }
    }

    override val data =
        InactivesProfilesData(
            initialState = InactivesProfilesState(),
        )

    override val uiData =
        InactivesProfilesUiData(
            initialState = InactivesProfilesUiState(),
        )

    fun navigateToEdit(profileId: String) {
        executeAction(HexagonNavigationAction.NavigateTo(FormRoute(profileId = profileId)))
    }

    fun remove(profile: PersonalProfile) {
        executeBlock(
            block = { deleteProfileUseCase(profile) },
        )
    }

    fun update(profile: PersonalProfile) {
        executeBlock(
            block = { updateProfileUseCase(profile) },
        )
    }

    init {
        observerInactivesProfiles()
    }

    private fun observerInactivesProfiles() {
        getInactivesProfilesUseCase()
            .distinctUntilChanged()
            .onEach { profiles ->
                data.updateProfilesList(profiles)
            }.launchIn(viewModelScope)
    }
}
