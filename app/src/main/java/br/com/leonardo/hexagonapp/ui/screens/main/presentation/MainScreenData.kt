package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.data.network.utils.NetworkState
import br.com.leonardo.appcore.presentation.data.data.HexagonData

/** Data holder for [MainScreenState]. */
class MainScreenData(
    initialState: MainScreenState,
) : HexagonData<MainScreenState>(initialState) {
    /** Updates notifications enabled flag in state. */
    fun updateNotificationsVisibility(showNotifications: Boolean) {
        updateState { it.copy(notificationsIsEnable = showNotifications) }
    }

    /** Updates network connection state in state. */
    fun updateNetworkStatus(networkStatus: NetworkState) {
        updateState { it.copy(networkStatus = networkStatus) }
    }

    /** Updates battery low status in state. */
    fun updateBatteryStatus(isLow: Boolean) {
        updateState { it.copy(batteryIsLow = isLow) }
    }
}
