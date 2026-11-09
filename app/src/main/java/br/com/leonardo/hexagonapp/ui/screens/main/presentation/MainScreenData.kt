package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.data.network.utils.NetworkState
import br.com.leonardo.appcore.presentation.data.data.HexagonData

class MainScreenData(
    initialState: MainScreenState,
) : HexagonData<MainScreenState>(initialState) {
    fun updateNotificationsVisibility(showNotifications: Boolean) {
        updateState { it.copy(notificationsIsEnable = showNotifications) }
    }

    fun updateNetworkStatus(networkStatus: NetworkState) {
        updateState { it.copy(networkStatus = networkStatus) }
    }

    fun updateBatteryStatus(isLow: Boolean) {
        updateState { it.copy(batteryIsLow = isLow) }
    }
}
