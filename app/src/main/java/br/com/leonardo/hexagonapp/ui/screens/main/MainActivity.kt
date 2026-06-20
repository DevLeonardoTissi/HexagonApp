package br.com.leonardo.hexagonapp.ui.screens.main

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import br.com.leonardo.hexagonapp.utils.extensions.context.toast
import br.com.leonardo.ui.action.HandleAction
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.action.HexagonNavigationAction
import br.com.leonardo.ui.navigator.HexagonNavigator
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val appViewModel: MainViewModel by viewModel()
    private val navigator: HexagonNavigator by inject()

    private val requestPermissionNotificationsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            onNotificationPermissionGranted()
        } else {
            onNotificationPermissionNotGranted()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        requestNotificationIfNeeded()

        appViewModel.setObserver(
            object : HandleAction {
                override fun handleAction(action: HexagonAction) {
                    if (action is HexagonNavigationAction) {
                        navigator.handleNavigatorAction(action)
                        return
                    }
                    appViewModel.handleAction(action)
                }
            }
        )

        lifecycleScope.launch {
            navigator.currentRouteFlow.collect { currentRoute ->
                currentRoute?.let {
                    appViewModel.handleAction(MainScreenActions.CurrencyRouteChanged(it))
                }
            }
        }

        setContent {

            val uiState by appViewModel.uiData.uiState.collectAsStateWithLifecycle()
            val state by appViewModel.data.state.collectAsStateWithLifecycle()

            HexagonAppTheme(darkTheme = uiState.isDarkMode) {
                MainScreen(
                    uiState,
                    state,
                    onActions = { action ->
                        appViewModel.executeAction(action)
                    },
                )
            }
        }
    }

    @SuppressLint("InlinedApi")
    private fun requestNotificationIfNeeded() {
        if (appViewModel.checkNotificationPermission()) {
            requestPermissionNotificationsLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun onNotificationPermissionGranted() {
        this.toast(getString(R.string.main_activity_toast_message_notifications_permission_granted))

    }

    private fun onNotificationPermissionNotGranted() {
        this.toast(getString(R.string.main_activity_toast_message_notifications_permission_not_granted))
    }
}
