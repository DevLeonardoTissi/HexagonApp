package br.com.leonardo.hexagonapp.ui.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.broadcasReceiver.BatteryStatusBroadcastReceiver
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import br.com.leonardo.hexagonapp.utils.extensions.context.toast
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModel()

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

        setContent {

            val appUiState by appViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()

            HexagonAppTheme(darkTheme = appUiState.isDarkMode) {
                MainScreen(
                    navController,
                    appUiState,
                    onCurrentRouteChange = { appUiState.onCurrentRouteChange(it) },
                    changeVisibilityBottomSheetConfigAndInfo = {
                        appUiState.changeVisibilityBottomSheetDialogInfoAndConfig(it)
                    },
                    onUpdateDarkMode = { appUiState.onDarkModeChange(it) },
                    onUpdateDrawerState = {
                        coroutineScope.launch {
                            appUiState.updateDrawer()
                        }
                    },
                    onUpdateShowNotification = {
                        appUiState.onShowNotificationsChange(it)
                    }
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



    override fun onDestroy() {
        appViewModel.unregisterReceivers()
        super.onDestroy()
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HexagonAppTheme {

    }
}