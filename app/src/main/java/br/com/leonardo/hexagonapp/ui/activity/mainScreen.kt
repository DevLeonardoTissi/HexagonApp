package br.com.leonardo.hexagonapp.ui.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.navigation.HexagonAppNavHost
import br.com.leonardo.hexagonapp.navigation.HexagonNavigatorImpl
import br.com.leonardo.hexagonapp.ui.APP_NAME
import br.com.leonardo.hexagonapp.ui.components.IconSecondaryColor
import br.com.leonardo.hexagonapp.ui.components.ModalBottomSheetMore
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.DevProfileScreenNavigator
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.route.DevProfileScreenRoute
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.navigation.route.FormRoute
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.hexagonapp.utils.AppRoute
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.webClient.utils.NetworkState
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(
    navigator: HexagonNavigator,
    navController: NavHostController,
    appUiState: AppUiState,
    onCurrentRouteChange: (String) -> Unit,
    changeVisibilityBottomSheetConfigAndInfo: (Boolean) -> Unit,
    onUpdateDarkMode: (Boolean) -> Unit,
    onUpdateDrawerState: () -> Unit,
    onUpdateShowNotification: (Boolean) -> Unit
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

    @Composable
    fun topAppBarTitle(): String {
        val titleResId = when (appUiState.currentRoute) {
            AppRoute.Form -> R.string.topAppBarFormTitle
            AppRoute.Inactive -> R.string.topAppBarInactiveTitle
            AppRoute.DevProfile -> R.string.topAppBarDevProfileTitle
            AppRoute.Home -> R.string.topAppBarActiveTitle
        }
        return stringResource(titleResId)
    }

    if (appUiState.showBottomSheetDialogInfoAndConfig) {
        ModalBottomSheetMore(
            onDismissRequest = {
                changeVisibilityBottomSheetConfigAndInfo(false)
            },
            isDarkMode = appUiState.isDarkMode, onDarkModeChange = { isDarkMode ->
                onUpdateDarkMode(isDarkMode)
            },
            showNotifications = appUiState.showNotifications,
            onShowNotificationChange = { showNotification ->
                onUpdateShowNotification(showNotification)
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
                            contentDescription = stringResource(R.string.iconCloseForCloseMenuDrawer)
                        )
                    }
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(20.dp))
                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            imageVector = Icons.Default.Home,
                            contentDescription = stringResource(R.string.iconHomeForNavigateToHomeScreenMenuDrawer)
                        )
                    },
                    label = { Text(stringResource(R.string.menuDrawerHomeOption)) },
                    selected = appUiState.isHomeScreen(),
                    onClick = {
                        navigator.navigateTo(HomeRoute, navOptions {
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
                            contentDescription = stringResource(R.string.iconAddForNavigateToFormScreenMenuDrawer)
                        )
                    },
                    label = { Text(stringResource(R.string.menuDrawerInsertOption)) },
                    selected = appUiState.isFormScreen(),
                    onClick = {
                        navigator.navigateTo(FormRoute())
                        onUpdateDrawerState()
                    })

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.AccountCircle,
                            contentDescription = stringResource(R.string.iconForNavigateToInactiveScreenMenuDrawer)
                        )
                    },
                    label = { Text(stringResource(R.string.menuDrawerInactiveOption)) },
                    selected = appUiState.isInactiveScreen(),
                    onClick = {
                        navigator.navigateTo(InactiveRoute)
                        onUpdateDrawerState()
                    })

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.Face,
                            contentDescription = stringResource(R.string.iconForNavigateToDevProfileScreenMenuDrawer)
                        )
                    },
                    label = { Text(stringResource(R.string.menuDrawerDevProfileOption)) },
                    selected = appUiState.isDevProfileScreen(),
                    onClick = {
                        navigator.navigateTo(DevProfileScreenRoute)
                        onUpdateDrawerState()
                    })

                Spacer(modifier = Modifier.weight(1f))

                NavigationDrawerItem(
                    icon = {
                        IconSecondaryColor(
                            Icons.Default.Info,
                            contentDescription = stringResource(R.string.iconForHelpMenuDrawer)
                        )
                    },
                    label = { Text(stringResource(R.string.menuDrawerHelpOption)) },
                    selected = false,
                    onClick = {
                        showSnackBar()
                        onUpdateDrawerState()
                    })
            }
        }, drawerState = appUiState.drawerState) {

            Scaffold(floatingActionButton = {
                if (appUiState.showAddFloatingActionButton) {
                    FloatingActionButton(onClick = { navigator.navigateTo(
                        FormRoute()) }) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = stringResource(R.string.iconAddForNavigateToFormFloatingButton)
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
                                contentDescription = stringResource(R.string.iconMoreForInfoAndConfiguration)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {

                            if (appUiState.isHomeScreen()) {
                                onUpdateDrawerState()
                            } else {
                                navigator.popUp()
                            }
                        }) {
                            if (appUiState.isHomeScreen()) {
                                Icon(
                                    Icons.AutoMirrored.Filled.List,
                                    contentDescription = stringResource(R.string.iconListForOpenMenuDrawer)
                                )
                            } else {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = stringResource(R.string.iconBackForNavigateUp)
                                )
                            }
                        }
                    })
            }) { paddingValues ->
                Box(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.padding(paddingValues)) {
                        HexagonAppNavHost(navController = navController)
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(paddingValues)
                    ) {

                        Column {
                            if (appUiState.networkStatus is NetworkState.Lost) {
                                val composition by rememberLottieComposition(
                                    spec = LottieCompositionSpec.RawRes(
                                        R.raw.no_wifi_icon
                                    )
                                )
                                LottieAnimation(
                                    composition = composition,
                                    iterations = LottieConstants.IterateForever,
                                    modifier = Modifier.size(60.dp)
                                )
                            }
                            if (appUiState.batteryIsLow) {
                                val composition by rememberLottieComposition(
                                    spec = LottieCompositionSpec.RawRes(
                                        R.raw.low_battery
                                    )
                                )
                                LottieAnimation(
                                    composition = composition,
                                    iterations = LottieConstants.IterateForever,
                                    modifier = Modifier.size(60.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}