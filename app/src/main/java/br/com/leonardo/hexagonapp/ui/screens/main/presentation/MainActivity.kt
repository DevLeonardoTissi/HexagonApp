package br.com.leonardo.hexagonapp.ui.screens.main.presentation

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
import br.com.leonardo.appcore.presentation.action.ActivityHandler
import br.com.leonardo.appcore.presentation.action.HandleAction
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.action.HexagonNavigationAction
import br.com.leonardo.appcore.presentation.navigator.HexagonScreenInnerNavigator
import br.com.leonardo.appcore.presentation.utils.extensions.toast
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.scope.Scope

/**
 * Main activity entry point for the application.
 * Hosts Compose UI tree, Navigation Drawer, and handles runtime permission requests.
 */
class MainActivity :
    ComponentActivity(),
    ActivityHandler,
    HandleAction,
    KoinScopeComponent {
    override val scope: Scope by lazy { getKoin().createScope(this) }

    private val appViewModel: MainViewModel by viewModel()
    private val innerNavigator: HexagonScreenInnerNavigator by scope.inject()

    private val requestPermissionNotificationsLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted: Boolean ->
            if (isGranted) {
                onNotificationPermissionGranted()
            } else {
                onNotificationPermissionNotGranted()
            }
        }

    override fun handleScreenAction(action: HexagonAction) {
        if (action is HexagonNavigationAction) {
            innerNavigator.handleNavigatorAction(action)
        } else {
            handleAction(action)
        }
    }

    override fun handleAppViewModelAction(action: HexagonAction) {
        if (action is HexagonNavigationAction) {
            innerNavigator.handleNavigatorAction(action)
        } else {
            appViewModel.handleAction(action)
        }
    }

    @Suppress("EmptyFunctionBlock")
    override fun handleAction(action: HexagonAction) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scope.declare(this)

        installSplashScreen()
        requestNotificationIfNeeded()

        appViewModel.setObserver(
            object : HandleAction {
                override fun handleAction(action: HexagonAction) {
                    this@MainActivity.handleAppViewModelAction(action)
                }
            },
        )

        lifecycleScope.launch {
            innerNavigator.currentRouteFlow.collect { currentRoute ->
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
