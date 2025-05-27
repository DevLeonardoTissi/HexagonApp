package br.com.leonardo.hexagonapp.ui.activity

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.formRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.homeRoute
import br.com.leonardo.hexagonapp.ui.activity.AppUiState.Companion.inactiveRoute
import br.com.leonardo.hexagonapp.utils.AppRoute
import br.com.leonardo.hexagonapp.utils.NetworkState
import br.com.leonardo.localData.model.Settings
import br.com.leonardo.localData.usecase.SearchSettingsUseCase
import br.com.leonardo.localData.usecase.UpdateSettingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val searchSettingsUseCase: SearchSettingsUseCase,
    private val updateSettingsUseCase: UpdateSettingsUseCase,
    connectivityManager: ConnectivityManager
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
        monitorNetwork(connectivityManager)
        observerSettings()
    }

    private fun observerSettings(){
        searchSettingsUseCase().onEach { settings ->
            _uiState.update {
                it.copy(
                    isDarkMode = settings.darkMode,
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun monitorNetwork(connectivityManager: ConnectivityManager) {
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()


        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = NetworkState.Avaliable(network))
                }
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                _uiState.update { currentState ->
                    currentState.copy(
                        networkStatus = NetworkState.CapabilitiesChanged(
                            network,
                            networkCapabilities
                        )
                    )
                }
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                _uiState.update { currentState ->
                    currentState.copy(networkStatus = NetworkState.Lost)
                }
            }
        }

        connectivityManager.requestNetwork(networkRequest, networkCallback)
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