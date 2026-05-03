package br.com.leonardo.hexagonapp.ui.screens.actives

import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.navigation.route.FormRoute
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetActivesProfilesUseCase
import br.com.leonardo.localData.usecase.UpdateProfileUseCase
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ActivesProfilesViewModel(
    private val getActivesProfilesUseCase: GetActivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase
) : HexagonViewModel<
        ActivesProfilesActions,
        ActivesProfilesState,
        ActivesProfilesData,
        ActivesProfilesUiState,
        ActivesProfilesUiData>() {

    override val data = ActivesProfilesData(
        initialState = ActivesProfilesState()
    )
    override val uiData = ActivesProfilesUiData(
        initialState = ActivesProfilesUiState()
    )


    override fun handleAction(action: ActivesProfilesActions) {
        when (action) {
            is ActivesProfilesActions.DeleteProfile -> remove(action.profile)
            is ActivesProfilesActions.UpdateProfile -> update(action.profile)
            is ActivesProfilesActions.ClickProfile -> navigateToEdit(action.profileId)
        }
    }

    fun remove(profile: PersonalProfile) {
        executeBlock(
            block = { deleteProfileUseCase(profile) }
        )
    }

    fun update(profile: PersonalProfile) {
        executeBlock(
            block = { updateProfileUseCase(profile)}
        )
    }

    fun navigateToEdit(profileId:String){
        navigator.navigateTo(FormRoute(profileId = profileId))
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
                //////
            }
            .launchIn(viewModelScope)
    }
}