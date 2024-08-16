package br.com.leonardo.hexagonapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val appViewModel: AppViewModel = koinViewModel()
            val appUiState by appViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()

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


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HexagonAppTheme {

    }
}