package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.ui.screens.utils.HexagonAction

sealed class DevProfileActions : HexagonAction() {
    object Load: DevProfileActions()
    class ChangeVisibilityBottomSheetShare(val visibility: Boolean): DevProfileActions()
    object Refresh: DevProfileActions()

}