package br.com.leonardo.ui.navigator

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.flow.Flow

 class HexagonNavigator(val startDestination: Route) {
    val backstack: SnapshotStateList<Route> = mutableStateListOf(startDestination)
    val currentRouteFlow: Flow<Route?> = snapshotFlow { backstack.lastOrNull() }

    fun navigateTo(destination: Route) {
      if(destination == startDestination){
          backstack.clear()
      }
        backstack.add(destination)
    }

    fun goBack() {
        backstack.removeLastOrNull()
    }

}