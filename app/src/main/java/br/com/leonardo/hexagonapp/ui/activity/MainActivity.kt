package br.com.leonardo.hexagonapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.navigation.HexagonAppNavHost
import br.com.leonardo.hexagonapp.navigation.navigateToDevProfile
import br.com.leonardo.hexagonapp.navigation.navigateToForm
import br.com.leonardo.hexagonapp.navigation.navigateToHome
import br.com.leonardo.hexagonapp.navigation.navigateToInactive
import br.com.leonardo.hexagonapp.ui.APP_NAME
import br.com.leonardo.hexagonapp.ui.components.IconSecondaryColor
import br.com.leonardo.hexagonapp.ui.components.ModalBottomSheetMore
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val appViewModel: AppViewModel = koinViewModel()
            val appUiState by appViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            val snackBarHost = remember { SnackbarHostState() }

            LaunchedEffect(navController) {
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    destination.route?.let {
                        appUiState.onCurrentRouteChange(it)
                    }
                }
            }

            fun updateDrawer() {
                coroutineScope.launch {
                    appUiState.updateDrawer()
                }
            }

            fun showSnackBar() {
                coroutineScope.launch {
                    snackBarHost.showSnackbar(
                        getString(R.string.snackBarHelpMessage),
                        duration = SnackbarDuration.Short
                    )
                }
            }

            fun topAppBarTitle(): String {
                return if (appUiState.isFormScreen) {
                    getString(R.string.topAppBarFormTitle)
                } else if (appUiState.isInactiveScreen) {
                    getString(R.string.topAppBarInactiveTitle)
                } else if (appUiState.isDevProfileScreen) {
                    getString(R.string.topAppBarDevProfileTitle)
                } else {
                    getString(R.string.topAppBarActiveTitle)
                }
            }

            if (appUiState.showBottomSheetDialogInfoAndConfig) {
                ModalBottomSheetMore(
                    onDismissRequest = {
                        appUiState.changeVisibilityBottomSheetDialogInfoAndConfig(
                            false
                        )
                    },
                    isDarkMode = appUiState.isDarkMode, onDarkModeChange = { isDarkMode ->
                        appUiState.onDarkModeChange(isDarkMode)
                    }
                )
            }

            HexagonAppTheme(darkTheme = appUiState.isDarkMode) {
                Surface {
                    ModalNavigationDrawer(drawerContent = {
                        ModalDrawerSheet {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(APP_NAME, modifier = Modifier.padding(16.dp))
                                IconButton(onClick = { updateDrawer() }
                                ) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = getString(R.string.iconCloseForCloseMenuDrawer)
                                    )
                                }
                            }
                            HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                            Spacer(modifier = Modifier.height(20.dp))
                            NavigationDrawerItem(
                                icon = {
                                    IconSecondaryColor(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = getString(R.string.iconHomeForNavigateToHomeScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerHomeOption)) },
                                selected = appUiState.isHomeScreen,
                                onClick = {
                                    navController.navigateToHome()
                                    updateDrawer()
                                })

                            NavigationDrawerItem(
                                icon = {
                                    IconSecondaryColor(
                                        Icons.Default.AddCircle,
                                        contentDescription = getString(R.string.iconAddForNavigateToFormScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerInsertOption)) },
                                selected = appUiState.isFormScreen,
                                onClick = {
                                    navController.navigateToForm()
                                    updateDrawer()
                                })

                            NavigationDrawerItem(
                                icon = {
                                    IconSecondaryColor(
                                        Icons.Default.AccountCircle,
                                        contentDescription = getString(R.string.iconForNavigateToInactiveScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerInactiveOption)) },
                                selected = appUiState.isInactiveScreen,
                                onClick = {
                                    navController.navigateToInactive()
                                    updateDrawer()
                                })

                            NavigationDrawerItem(
                                icon = {
                                    IconSecondaryColor(
                                        Icons.Default.Face,
                                        contentDescription = getString(R.string.iconForNavigateToDevProfileScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerDevProfileOption)) },
                                selected = appUiState.isDevProfileScreen,
                                onClick = {
                                    navController.navigateToDevProfile()
                                    updateDrawer()
                                })

                            Spacer(modifier = Modifier.weight(1f))

                            NavigationDrawerItem(
                                icon = {
                                    IconSecondaryColor(
                                        Icons.Default.Info,
                                        contentDescription = getString(R.string.iconForHelpMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerHelpOption)) },
                                selected = false,
                                onClick = {
                                    showSnackBar()
                                    updateDrawer()
                                })
                        }
                    }, drawerState = appUiState.drawerState) {

                        Scaffold(floatingActionButton = {
                            if (appUiState.showAddFloatingActionButton) {
                                FloatingActionButton(onClick = { navController.navigateToForm() }) {
                                    Icon(
                                        Icons.Default.Add,
                                        contentDescription = getString(R.string.iconAddForNavigateToFormFloatingButton)
                                    )
                                }
                            }
                        }, snackbarHost = {
                            SnackbarHost(hostState = snackBarHost) { snackBarData ->
                                Snackbar(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        text = snackBarData.visuals.message,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }, topBar = {
                            CenterAlignedTopAppBar(
                                title = { Text(topAppBarTitle()) },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),
                                actions = {
                                    IconButton(onClick = {
                                        appUiState.changeVisibilityBottomSheetDialogInfoAndConfig(
                                            true
                                        )
                                    }) {
                                        Icon(
                                            Icons.Default.MoreVert,
                                            contentDescription = getString(R.string.iconMoreForInfoAndConfiguration)
                                        )
                                    }
                                },
                                navigationIcon = {
                                    IconButton(onClick = {

                                        if (appUiState.isHomeScreen) {
                                            updateDrawer()
                                        } else {
                                            navController.navigateUp()
                                        }
                                    }) {
                                        if (appUiState.isHomeScreen) {
                                            Icon(
                                                Icons.AutoMirrored.Filled.List,
                                                contentDescription = getString(R.string.iconListForOpenMenuDrawer)
                                            )
                                        } else {
                                            Icon(
                                                Icons.AutoMirrored.Filled.ArrowBack,
                                                contentDescription = getString(R.string.iconBackForNavigateUp)
                                            )
                                        }
                                    }
                                })
                        }) { paddingValues ->
                            Box(modifier = Modifier.padding(paddingValues)) {
                                HexagonAppNavHost(navController = navController)
                            }
                        }
                    }
                }
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