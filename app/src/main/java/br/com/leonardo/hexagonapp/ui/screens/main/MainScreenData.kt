package br.com.leonardo.hexagonapp.ui.screens.main

import br.com.leonardo.ui.data.data.HexagonData
import br.com.leonardo.webClient.utils.NetworkState

class MainScreenData(initialState: MainScreenState) : HexagonData<MainScreenState>(initialState) {

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