package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.model.Settings
import br.com.leonardo.hexagonapp.navigation.devProfileRoute
import br.com.leonardo.hexagonapp.navigation.formRoute
import br.com.leonardo.hexagonapp.navigation.homeRoute
import br.com.leonardo.hexagonapp.navigation.inactiveRoute
import br.com.leonardo.hexagonapp.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(private val repository: SettingsRepository) : ViewModel() {

    val settings: Flow<Settings> = repository.searchSettings()

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    private fun toggleDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            repository.updateSettings(Settings(darkMode = darkMode))
        }
    }

    init {
        viewModelScope.launch {
            settings.collect { settings ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isDarkMode = settings.darkMode,
                        loadingSettings = false,
                        onDarkModeChange = { isDarkMode ->
                            toggleDarkMode(isDarkMode)
                        },
                        changeVisibilityBottomSheetDialogInfoAndConfig = { showBottomSheetDialogInfoAndConfig ->
                            _uiState.value =
                                _uiState.value.copy(showBottomSheetDialogInfoAndConfig = showBottomSheetDialogInfoAndConfig)
                        },
                        onCurrentRouteChange = { route ->
                            _uiState.value = _uiState.value.copy(
                                currentRoute = route,
                                isHomeScreen = route == homeRoute,
                                isFormScreen = route.contains(formRoute) ,
                                isInactiveScreen = route == inactiveRoute,
                                isDevProfileScreen = route == devProfileRoute,
                                showAddFloatingActionButton = route == homeRoute
                            )
                        }
                    )
                }
            }
        }
    }
}