package br.com.leonardo.hexagonapp.ui.screens.main

import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.webClient.utils.NetworkState

data class MainScreenState(
    val notificationsIsEnable: Boolean = false,
    val networkStatus: NetworkState = NetworkState.Lost,
    val batteryIsLow: Boolean = false
) : HexagonState