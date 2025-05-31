package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.formRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.homeRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.inactiveRoute
import br.com.leonardo.hexagonapp.utils.AppRoute
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase
import br.com.leonardo.webClient.utils.NetworkMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val searchSettingsUseCase: SearchSettingsUseCase,
    private val updateSettingsUseCase: UpdateSettingsUseCase,
    private val networkMonitor: NetworkMonitor
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        AppUiState(
            onDarkModeChange = ::toggleDarkMode,
            changeVisibilityBottomSheetDialogInfoAndConfig = ::setBottomSheetVisibility,
            onCurrentRouteChange = ::onRouteChanged
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        observerSettings()
        networkMonitor()
    }

    private fun observerSettings() {
        searchSettingsUseCase().onEach { settings ->
            _uiState.update {
                it.copy(
                    isDarkMode = settings.darkMode,
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun networkMonitor() {
        networkMonitor.monitor(
            onConnectionCapabilitiesChanged = { state ->
                _uiState.update { currentState ->
                    currentState.copy(
                        networkStatus = state
                    )
                }
            },
            onConnectionAvailable = { state ->
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = state)
                }
            },
            onConnectionLost = { state ->
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = state)
                }
            }
        )
    }

    private fun toggleDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase(Settings(darkMode = darkMode))
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

    private fun onRouteChanged(route: String) {
        val currentRoute = updateRoute(route)
        _uiState.update {
            it.copy(
                currentRoute = currentRoute,
                showAddFloatingActionButton = currentRoute == AppRoute.Home
            )
        }
    }

    fun setBatteryLow(isLow: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(batteryIsLow = isLow)
        }
    }

    private fun setBottomSheetVisibility(show: Boolean) {
        _uiState.update { it.copy(showBottomSheetDialogInfoAndConfig = show) }
    }
}