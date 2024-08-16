package br.com.leonardo.hexagonapp.ui.activity

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.navigation.DevProfileRoute
import br.com.leonardo.hexagonapp.navigation.FormRoute
import br.com.leonardo.hexagonapp.navigation.HexagonAppNavHost
import br.com.leonardo.hexagonapp.navigation.HomeRoute
import br.com.leonardo.hexagonapp.navigation.InactiveRoute
import br.com.leonardo.hexagonapp.ui.APP_NAME
import br.com.leonardo.hexagonapp.ui.components.IconSecondaryColor
import br.com.leonardo.hexagonapp.ui.components.ModalBottomSheetMore
import br.com.leonardo.hexagonapp.utils.AppRoute
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(
    navController: NavHostController,
    appUiState: AppUiState,
    onCurrentRouteChange: (String) -> Unit,
    changeVisibilityBottomSheetConfigAndInfo: (Boolean) -> Unit,
    onUpdateDarkMode: (Boolean) -> Unit,
    onUpdateDrawerState: () -> Unit
) {

    val snackBarHost = remember { SnackbarHostState() }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            destination.route?.let {
                onCurrentRouteChange(it)
            }
        }
    }

    fun showSnackBar() {
        coroutineScope.launch {
            snackBarHost.showSnackbar(
                context.getString(R.string.snackBarHelpMessage),
                duration = SnackbarDuration.Short
            )
        }
    }

    fun topAppBarTitle(): String {
        val titleResId = when (appUiState.currentRoute) {
            AppRoute.Form -> R.string.topAppBarFormTitle
            AppRoute.Inactive -> R.string.topAppBarInactiveTitle
            AppRoute.DevProfile -> R.string.topAppBarDevProfileTitle
            AppRoute.Home -> R.string.topAppBarActiveTitle
        }
        return context.getString(titleResId)
    }

    if (appUiState.showBottomSheetDialogInfoAndConfig) {
        ModalBottomSheetMore(
            onDismissRequest = {
                changeVisibilityBottomSheetConfigAndInfo(false)
            },
            isDarkMode = appUiState.isDarkMode, onDarkModeChange = { isDarkMode ->
                onUpdateDarkMode(isDarkMode)
            }
        )
    }

    Surface {
        ModalNavigationDrawer(drawerContent = {
            ModalDrawerSheet {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(APP_NAME, modifier = Modifier.padding(16.dp))
                    IconButton(onClick = { onUpdateDrawerState() }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = context.getString(R.string.iconCloseForCloseMenuDrawer)
                        )
                    }
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(20.dp))
                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            imageVector = Icons.Default.Home,
                            contentDescription = context.getString(R.string.iconHomeForNavigateToHomeScreenMenuDrawer)
                        )
                    },
                    label = { Text(context.getString(R.string.menuDrawerHomeOption)) },
                    selected = appUiState.isHomeScreen(),
                    onClick = {
                        navController.navigate(HomeRoute, navOptions {
                            popUpTo(
                                HomeRoute
                            ) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        })
                        onUpdateDrawerState()
                    })

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.AddCircle,
                            contentDescription = context.getString(R.string.iconAddForNavigateToFormScreenMenuDrawer)
                        )
                    },
                    label = { Text(context.getString(R.string.menuDrawerInsertOption)) },
                    selected = appUiState.isFormScreen(),
                    onClick = {
                        navController.navigate(FormRoute())
                        onUpdateDrawerState()
                    })

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.AccountCircle,
                            contentDescription = context.getString(R.string.iconForNavigateToInactiveScreenMenuDrawer)
                        )
                    },
                    label = { Text(context.getString(R.string.menuDrawerInactiveOption)) },
                    selected = appUiState.isInactiveScreen(),
                    onClick = {
                        navController.navigate(InactiveRoute)
                        onUpdateDrawerState()
                    })

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.Face,
                            contentDescription = context.getString(R.string.iconForNavigateToDevProfileScreenMenuDrawer)
                        )
                    },
                    label = { Text(context.getString(R.string.menuDrawerDevProfileOption)) },
                    selected = appUiState.isDevProfileScreen(),
                    onClick = {
                        navController.navigate(DevProfileRoute)
                        onUpdateDrawerState()
                    })

                Spacer(modifier = Modifier.weight(1f))

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.Info,
                            contentDescription = context.getString(R.string.iconForHelpMenuDrawer)
                        )
                    },
                    label = { Text(context.getString(R.string.menuDrawerHelpOption)) },
                    selected = false,
                    onClick = {
                        showSnackBar()
                        onUpdateDrawerState()
                    })
            }
        }, drawerState = appUiState.drawerState) {

            Scaffold(floatingActionButton = {
                if (appUiState.showAddFloatingActionButton) {
                    FloatingActionButton(onClick = { navController.navigate(FormRoute()) }) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = context.getString(R.string.iconAddForNavigateToFormFloatingButton)
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
                            changeVisibilityBottomSheetConfigAndInfo(true)
                        }) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = context.getString(R.string.iconMoreForInfoAndConfiguration)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {

                            if (appUiState.isHomeScreen()) {
                                onUpdateDrawerState()
                            } else {
                                navController.navigateUp()
                            }
                        }) {
                            if (appUiState.isHomeScreen()) {
                                Icon(
                                    Icons.AutoMirrored.Filled.List,
                                    contentDescription = context.getString(R.string.iconListForOpenMenuDrawer)
                                )
                            } else {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = context.getString(R.string.iconBackForNavigateUp)
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