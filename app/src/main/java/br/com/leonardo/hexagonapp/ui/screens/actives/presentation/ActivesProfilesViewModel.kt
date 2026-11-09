package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import androidx.lifecycle.viewModelScope
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.action.HexagonNavigationAction
import br.com.leonardo.appcore.presentation.viewmodel.HexagonViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.route.FormRoute
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetActivesProfilesUseCase
import br.com.leonardo.localData.usecase.UpdateProfileUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * ViewModel managing state and user actions for the Active Profiles screen.
 *
 * @property getActivesProfilesUseCase Use case for observing active profiles.
 * @property deleteProfileUseCase Use case for deleting a profile.
 * @property updateProfileUseCase Use case for updating a profile.
 */
class ActivesProfilesViewModel(
    private val getActivesProfilesUseCase: GetActivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
) : HexagonViewModel<
        ActivesProfilesState,
        ActivesProfilesData,
        ActivesProfilesUiState,
        ActivesProfilesUiData,
    >() {
    override val data =
        ActivesProfilesData(
            initialState = ActivesProfilesState(),
        )
    override val uiData =
        ActivesProfilesUiData(
            initialState = ActivesProfilesUiState(),
        )

    override fun handleAction(action: HexagonAction) {
        when (action) {
            is ActivesProfilesActions.DeleteProfile -> remove(action.profile)
            is ActivesProfilesActions.UpdateProfile -> update(action.profile)
            is ActivesProfilesActions.ClickProfile -> navigateToEdit(action.profileId)
        }
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

    fun navigateToEdit(profileId: String) {
        executeAction(HexagonNavigationAction.NavigateTo(FormRoute(profileId = profileId)))
    }

    init {
        observerActivesProfiles()
    }

    private fun observerActivesProfiles() {
        getActivesProfilesUseCase()
            .distinctUntilChanged()
            .onEach { profiles ->
                data.updateProfilesList(profiles)
            }.catch {
                // ////
            }.launchIn(viewModelScope)
    }
}
