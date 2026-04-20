package br.com.leonardo.hexagonapp.ui.screens.inactives

import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetInactivesProfilesUseCase
import br.com.leonardo.localData.usecase.UpdateProfileUseCase
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import kotlin.getValue

class InactivesProfilesViewModel(
    private val getInactivesProfilesUseCase: GetInactivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
) : HexagonViewModel<
        InactivesProfilesActions,
        InactivesProfilesState,
        InactivesProfilesData,
        InactivesProfilesUiState,
        InactivesProfilesUiData>() {

    override fun handleAction(action: InactivesProfilesActions) {
        when (action) {
            is InactivesProfilesActions.DeleteProfile -> remove(action.profile)
            is InactivesProfilesActions.UpdateProfile -> update(action.profile)
            else -> {}
        }
    }

    override val data = InactivesProfilesData(
        initialState = InactivesProfilesState()
    )

    override val uiData = InactivesProfilesUiData(
        initialState = InactivesProfilesUiState()
    )

    fun remove(profile: PersonalProfile) {
        viewModelScope.launch {
            deleteProfileUseCase(profile)
        }
    }

    fun update(profile: PersonalProfile) {
        viewModelScope.launch {
            updateProfileUseCase(profile)
        }
    }

    init {
        observerInactivesProfiles()
    }

    private fun observerInactivesProfiles() {
        getInactivesProfilesUseCase()
            .distinctUntilChanged()
            .onEach { profiles ->
                data.updateProfilesList(profiles)
            }
            .launchIn(viewModelScope)
    }
}