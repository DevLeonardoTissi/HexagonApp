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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.model.Settings
import br.com.leonardo.hexagonapp.navigation.HexagonAppNavHost
import br.com.leonardo.hexagonapp.navigation.formRoute
import br.com.leonardo.hexagonapp.navigation.homeRoute
import br.com.leonardo.hexagonapp.navigation.inactiveRoute
import br.com.leonardo.hexagonapp.navigation.navigateToEdit
import br.com.leonardo.hexagonapp.navigation.navigateToForm
import br.com.leonardo.hexagonapp.navigation.navigateToHome
import br.com.leonardo.hexagonapp.navigation.navigateToInactive
import br.com.leonardo.hexagonapp.ui.APP_NAME
import br.com.leonardo.hexagonapp.ui.components.ModalBottomSheetMore
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val appViewModel: AppViewModel = koinViewModel()
            val settings by appViewModel.settings.collectAsStateWithLifecycle(Settings())
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val coroutineScope = rememberCoroutineScope()
            val openBottomSheetInfoAndConfig = remember { mutableStateOf(false) }

            fun toggleDrawer() {
                coroutineScope.launch {
                    if (drawerState.isOpen) drawerState.close() else drawerState.open()
                }
            }

            fun isHomeScreen() = backStackEntryState?.destination?.route == homeRoute
            fun isFormScreen() =
                backStackEntryState?.destination?.route?.contains(formRoute) == true

            fun isInactiveScreen() = backStackEntryState?.destination?.route == inactiveRoute

            fun topAppBarTitle(): String {
                return when (backStackEntryState?.destination?.route) {
                    homeRoute -> getString(R.string.topAppBarActiveTitle)
                    inactiveRoute -> getString(R.string.topAppBarInactiveTitle)
                    else -> {
                        if (backStackEntryState?.destination?.route?.contains(formRoute) == true) {
                            getString(R.string.topAppBarFormTitle)
                        } else {
                            getString(R.string.topAppBarActiveTitle)
                        }
                    }
                }
            }

            if (openBottomSheetInfoAndConfig.value) {
                ModalBottomSheetMore(
                    onDismissRequest = { openBottomSheetInfoAndConfig.value = false },
                    setting = settings, onNewSettings = { newSetting ->
                        appViewModel.updateSettings(newSetting)
                    }
                )
            }

            val snackBarHost = remember { SnackbarHostState() }
            HexagonAppTheme(darkTheme = settings.darkMode) {
                Surface {
                    ModalNavigationDrawer(drawerContent = {
                        ModalDrawerSheet {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(APP_NAME, modifier = Modifier.padding(16.dp))
                                IconButton(onClick = { toggleDrawer() }
                                ) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = getString(R.string.iconCloseForCloseMenuDrawer)
                                    )
                                }
                            }
                            Divider()
                            Spacer(modifier = Modifier.height(20.dp))
                            NavigationDrawerItem(
                                icon = {
                                    Icon(
                                        Icons.Default.Home,
                                        contentDescription = getString(R.string.iconHomeForNavigateToHomeScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerHomeOption)) },
                                selected = isHomeScreen(),
                                onClick = {
                                    navController.navigateToHome()
                                    toggleDrawer()
                                })

                            NavigationDrawerItem(
                                icon = {
                                    Icon(
                                        Icons.Default.AddCircle,
                                        contentDescription = getString(R.string.iconAddForNavigateToFormScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerInsertOption)) },
                                selected = isFormScreen(),
                                onClick = {
                                    navController.navigateToForm()
                                    toggleDrawer()
                                })

                            NavigationDrawerItem(
                                icon = {
                                    Icon(
                                        Icons.Default.AccountCircle,

                                        contentDescription = getString(R.string.iconForNavigateToInactiveScreenMenuDrawer)
                                    )
                                },
                                label = { Text(getString(R.string.menuDrawerInactiveOption)) },
                                selected = isInactiveScreen(),
                                onClick = {
                                    navController.navigateToInactive()
                                    toggleDrawer()
                                })
                        }
                    }, drawerState = drawerState) {
                        Scaffold(floatingActionButton = {
                            if (isHomeScreen()) {
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
                                        openBottomSheetInfoAndConfig.value = true
                                    }) {
                                        Icon(
                                            Icons.Default.MoreVert,
                                            contentDescription = getString(R.string.iconMoreForInfoAndConfiguration)
                                        )
                                    }
                                },
                                navigationIcon = {
                                    IconButton(onClick = {

                                        if (isHomeScreen()) {
                                            toggleDrawer()
                                        } else {
                                            navController.navigateUp()
                                        }
                                    }) {
                                        if (isHomeScreen()) {
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