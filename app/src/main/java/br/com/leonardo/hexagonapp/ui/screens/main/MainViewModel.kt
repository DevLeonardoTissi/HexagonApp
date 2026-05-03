package br.com.leonardo.hexagonapp.ui.screens.main

import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER
import br.com.leonardo.hexagonapp.usecase.BatteryMonitorUseCase
import br.com.leonardo.hexagonapp.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.hexagonapp.usecase.NotificationUseCase
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import br.com.leonardo.webClient.utils.networkMonitor.NetworkMonitor
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    private val searchSettingsUseCase: SearchSettingsUseCase,
    private val updateSettingsUseCase: UpdateSettingsUseCase,
    private val networkMonitor: NetworkMonitor,
    private val notificationUseCase: NotificationUseCase,
    private val checkNotificationPermissionUseCase: CheckNotificationPermissionUseCase,
    private val batteryMonitorUseCase: BatteryMonitorUseCase
) : HexagonViewModel<MainScreenActions, MainScreenState, MainScreenData, MainScreenUiState, MainScreenUiData>() {

    override val data = MainScreenData(MainScreenState())

    override val uiData = MainScreenUiData(MainScreenUiState())

    override fun handleAction(action: MainScreenActions) {

        when (action) {
            is MainScreenActions.ChangeDarkMode -> toggleDarkMode(action.isDarkMode)
            is MainScreenActions.ChangeNotificationsSettings -> toggleNotifications(action.showNotifications)
            is MainScreenActions.DisplayedBottomSheet -> executeDisplayedBottomSheetAction(action)
            is MainScreenActions.CurrentRouteChanged -> executeOnRouteChangedAction(action)
            is MainScreenActions.NavigateToRoute -> navigator.navigateTo(action.route, action.navOptions)
            is MainScreenActions.NavigateBack -> navigator.goBack()
            is MainScreenActions.NavigatePop -> navigator.popUp()
        }
    }

    private fun executeOnRouteChangedAction(action: MainScreenActions.CurrentRouteChanged) {
        val route = navigator.routeResolver(action.route)
        route?.let {
            uiData.updateCurrentRoute(it)
        }
    }

    private fun executeDisplayedBottomSheetAction(action: MainScreenActions.DisplayedBottomSheet) {
        uiData.updateBottomSheetVisibility(action.displayed)
    }


    init {
        observerSettings()
        networkMonitor()
        batteryMonitor()
    }

    fun unregisterReceivers() {
        batteryMonitorUseCase.unregisterReceiver()
    }

    private fun batteryMonitor() {
        batteryMonitorUseCase.monitor { isLow ->
            data.updateBatteryStatus(isLow)
        }
    }

    fun checkNotificationPermission(): Boolean = checkNotificationPermissionUseCase()

    private fun observerSettings() {
        searchSettingsUseCase().onEach { settings ->
            data.updateNotificationsVisibility(settings.showNotification)
            uiData.setDarkModeTheme(settings.darkMode)
        }.launchIn(viewModelScope)
    }

    private fun networkMonitor() {
        networkMonitor.monitor(
            onConnectionCapabilitiesChanged = { state ->
                data.updateNetworkStatus(state)

                if (notificationsEnabled()) {
                    cancelNotConnectionNotification()
                }
            },
            onConnectionAvailable = { state ->
                data.updateNetworkStatus(state)

                if (notificationsEnabled()) {
                    cancelNotConnectionNotification()
                }
            },
            onConnectionLost = { state ->
                data.updateNetworkStatus(state)

                if (notificationsEnabled()) {
                    launchNotConnectionNotification()
                }

            }
        )
    }

    private fun toggleDarkMode(darkMode: Boolean) {
        executeBlock(
            block = {
                updateSettingsUseCase(
                    Settings(
                        darkMode = darkMode,
                        showNotification = data.getState().notificationsIsEnable
                    )
                )
            })
    }

    private fun toggleNotifications(showNotifications: Boolean) {

        executeBlock(
            block = {
                updateSettingsUseCase(
                    Settings(
                        darkMode = uiData.getState().isDarkMode,
                        showNotification = showNotifications
                    )
                )
            })

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

    private fun notificationsEnabled(): Boolean = data.getState().notificationsIsEnable

    override fun onCleared() {
        super.onCleared()
        unregisterReceivers()
    }
}