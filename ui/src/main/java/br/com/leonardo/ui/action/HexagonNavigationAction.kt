package br.com.leonardo.ui.action

import br.com.leonardo.ui.navigator.Route

sealed class HexagonNavigationAction : HexagonAction() {

    object GoBack : HexagonNavigationAction()
    class NavigateTo(val route: Route) : HexagonNavigationAction()

}