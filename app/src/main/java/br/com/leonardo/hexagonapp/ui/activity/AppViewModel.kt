package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.formRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.homeRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.inactiveRoute
import br.com.leonardo.hexagonapp.usecase.BatteryMonitorUseCase
import br.com.leonardo.hexagonapp.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.hexagonapp.usecase.NotificationUseCase
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
    private val networkMonitor: NetworkMonitor,
    private val notificationUseCase: NotificationUseCase,
    private val checkNotificationPermissionUseCase: CheckNotificationPermissionUseCase,
    private val batteryMonitorUseCase : BatteryMonitorUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        AppUiState(
            onDarkModeChange = ::toggleDarkMode,
            changeVisibilityBottomSheetDialogInfoAndConfig = ::setBottomSheetVisibility,
            onCurrentRouteChange = ::onRouteChanged,
            onShowNotificationsChange = ::toggleNotifications
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        observerSettings()
        networkMonitor()
        batteryMonitor()
    }

    fun unregisterReceivers(){
        batteryMonitorUseCase.unregisterReceiver()
    }

    private fun batteryMonitor(){
        batteryMonitorUseCase.monitor { isLow ->
            setBatteryLow(isLow)
        }
    }

    fun checkNotificationPermission(): Boolean = checkNotificationPermissionUseCase()

    private fun observerSettings() {
        searchSettingsUseCase().onEach { settings ->
            _uiState.update {
                it.copy(
                    isDarkMode = settings.darkMode,
                    showNotifications = settings.showNotification

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

                if (notificationsEnabled()) {
                    cancelNotConnectionNotification()
                }
            },
            onConnectionAvailable = { state ->
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = state)
                }

                if (notificationsEnabled()) {
                    cancelNotConnectionNotification()
                }
            },
            onConnectionLost = { state ->
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = state)
                }

                if (notificationsEnabled()) {
                    launchNotConnectionNotification()
                }

            }
        )
    }

    private fun toggleDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase(
                Settings(
                    darkMode = darkMode,
                    showNotification = uiState.value.showNotifications
                )
            )
        }
    }

    private fun toggleNotifications(showNotifications: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase(
                Settings(
                    darkMode = uiState.value.isDarkMode,
                    showNotification = showNotifications
                )
            )
        }

        if (!showNotifications) {
            cancelAllNotifications()
        }

    }

    private fun cancelAllNotifications() {
        notificationUseCase.cancelAll()
    }

    private fun cancelNotConnectionNotification() {
        notificationUseCase.cancel(NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER)

    }

    private fun launchNotConnectionNotification() {
        notificationUseCase.show(
            titleStringId = R.string.no_connection_notification_title,
            descriptionStringId = R.string.no_connection_notification_description,
            iconId = R.drawable.no_wifi,
            exclusiveId = NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER
        )
    }

    private fun notificationsEnabled(): Boolean = uiState.value.showNotifications

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

    private fun setBatteryLow(isLow: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(batteryIsLow = isLow)
        }
    }

    private fun setBottomSheetVisibility(show: Boolean) {
        _uiState.update { it.copy(showBottomSheetDialogInfoAndConfig = show) }
    }
}