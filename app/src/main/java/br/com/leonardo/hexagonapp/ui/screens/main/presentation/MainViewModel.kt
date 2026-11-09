package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import androidx.lifecycle.viewModelScope
import br.com.leonardo.appcore.data.network.utils.networkMonitor.NetworkMonitor
import br.com.leonardo.appcore.domain.usecase.BatteryMonitorUseCase
import br.com.leonardo.appcore.domain.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.appcore.domain.usecase.NotificationUseCase
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.viewmodel.HexagonViewModel
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * ViewModel managing root application state, network status, battery monitoring, and settings.
 *
 * @property searchSettingsUseCase Use case for loading app settings.
 * @property updateSettingsUseCase Use case for saving app settings.
 * @property networkMonitor Real-time network connectivity status monitor.
 * @property notificationUseCase Service for dispatching notifications.
 * @property checkNotificationPermissionUseCase Verifier for notification permission.
 * @property batteryMonitorUseCase Real-time device battery monitor.
 */
@Suppress("detekt.TooManyFunctions")
class MainViewModel(
    private val searchSettingsUseCase: SearchSettingsUseCase,
    private val updateSettingsUseCase: UpdateSettingsUseCase,
    private val networkMonitor: NetworkMonitor,
    private val notificationUseCase: NotificationUseCase,
    private val checkNotificationPermissionUseCase: CheckNotificationPermissionUseCase,
    private val batteryMonitorUseCase: BatteryMonitorUseCase,
) : HexagonViewModel<MainScreenState, MainScreenData, MainScreenUiState, MainScreenUiData>() {
    override val data = MainScreenData(MainScreenState())
    override val uiData = MainScreenUiData(MainScreenUiState())

    override fun handleAction(action: HexagonAction) {
        when (action) {
            is MainScreenActions.ChangeDarkMode -> toggleDarkMode(action.isDarkMode)
            is MainScreenActions.ChangeNotificationsSettings -> toggleNotifications(action.showNotifications)
            is MainScreenActions.DisplayedBottomSheet -> executeDisplayedBottomSheetAction(action)
            is MainScreenActions.CurrencyRouteChanged -> onCurrentRouteChanged(action)
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

    fun onCurrentRouteChanged(action: MainScreenActions.CurrencyRouteChanged) {
        uiData.updateCurrentRoute(action.route)
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
        searchSettingsUseCase()
            .onEach { settings ->
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
            },
        )
    }

    private fun toggleDarkMode(darkMode: Boolean) {
        executeBlock(
            block = {
                updateSettingsUseCase(
                    Settings(
                        darkMode = darkMode,
                        showNotification = data.getState().notificationsIsEnable,
                    ),
                )
            },
        )
    }

    private fun toggleNotifications(showNotifications: Boolean) {
        executeBlock(
            block = {
                updateSettingsUseCase(
                    Settings(
                        darkMode = uiData.getState().isDarkMode,
                        showNotification = showNotifications,
                    ),
                )
            },
        )

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
            exclusiveId = NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER,
        )
    }

    private fun notificationsEnabled(): Boolean = data.getState().notificationsIsEnable

    override fun onCleared() {
        unregisterReceivers()
    }
}

const val NOTIFICATIONS_NETWORK_ERROR_IDENTIFIER = 1001
