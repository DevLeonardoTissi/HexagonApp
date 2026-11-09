package br.com.leonardo.appcore.presentation.data.uistate

/**
 * Hexagon refreshable ui state
 *
 * @property isRefreshing the is refreshing
 */
interface HexagonRefreshableUIState : HexagonUIState {
    val isRefreshing: Boolean
}
