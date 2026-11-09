package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.data.network.utils.NetworkState
import br.com.leonardo.appcore.presentation.data.state.HexagonState

data class MainScreenState(
    val notificationsIsEnable: Boolean = false,
    val networkStatus: NetworkState = NetworkState.Lost,
    val batteryIsLow: Boolean = false,
) : HexagonState
