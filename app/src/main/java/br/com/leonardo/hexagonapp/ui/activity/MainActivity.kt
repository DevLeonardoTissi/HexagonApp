package br.com.leonardo.hexagonapp.ui.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.leonardo.hexagonapp.broadcasReceiver.BatteryStatusBroadcastReceiver
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import br.com.leonardo.hexagonapp.utils.NetworkState
import br.com.leonardo.hexagonapp.utils.extensions.toast
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    private val appViewModel: AppViewModel by viewModel()
    private val batteryReceiver = BatteryStatusBroadcastReceiver { isLow ->
        appViewModel.setBatteryLow(isLow)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        checkBatteryLevelInit()

        setContent {

            val appUiState by appViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()


            val intentFilter = IntentFilter().apply {
                addAction(Intent.ACTION_BATTERY_LOW)
                addAction(Intent.ACTION_BATTERY_OKAY)
            }
            registerReceiver(batteryReceiver, intentFilter)

            HexagonAppTheme(darkTheme = appUiState.isDarkMode) {
                MainScreen(
                    navController,
                    appUiState,
                    onCurrentRouteChange = { appUiState.onCurrentRouteChange(it) },
                    changeVisibilityBottomSheetConfigAndInfo = {
                        appUiState.changeVisibilityBottomSheetDialogInfoAndConfig(
                            it
                        )
                    },
                    onUpdateDarkMode = { appUiState.onDarkModeChange(it) },
                    onUpdateDrawerState = {
                        coroutineScope.launch {
                            appUiState.updateDrawer()
                        }
                    }
                )
            }
        }
    }

    private fun isBatteryLowNow(): Boolean {
        val intent = registerReceiver(
            null, IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        ) ?: return false

        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level / scale.toFloat()
        return batteryPct <= 0.15f
    }

    private fun checkBatteryLevelInit() {
        if (isBatteryLowNow()) {
            appViewModel.setBatteryLow(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryReceiver)
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HexagonAppTheme {

    }
}