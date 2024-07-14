package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.repository.SettingsRepository
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.formRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.homeRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.inactiveRoute
import br.com.leonardo.hexagonapp.utils.AppRoute
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

    private fun updateRoute(route: String): AppRoute {
        return when {
            route.contains(homeRoute) -> AppRoute.Home
            route.contains(formRoute) -> AppRoute.Form
            route.contains(inactiveRoute) -> AppRoute.Inactive
            else -> AppRoute.DevProfile
        }
    }

    init {
        viewModelScope.launch {
            settings.collect { settings ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isDarkMode = settings.darkMode,
                        onDarkModeChange = { isDarkMode ->
                            toggleDarkMode(isDarkMode)
                        },
                        changeVisibilityBottomSheetDialogInfoAndConfig = { showBottomSheetDialogInfoAndConfig ->
                            _uiState.value =
                                _uiState.value.copy(showBottomSheetDialogInfoAndConfig = showBottomSheetDialogInfoAndConfig)
                        },
                        onCurrentRouteChange = { route ->
                            val currentRoute = updateRoute(route)
                            _uiState.value = _uiState.value.copy(
                                currentRoute = currentRoute,
                                showAddFloatingActionButton = currentRoute == AppRoute.Home
                            )
                        }
                    )
                }
            }
        }
    }
}