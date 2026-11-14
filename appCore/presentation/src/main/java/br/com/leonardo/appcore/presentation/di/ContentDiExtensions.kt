package br.com.leonardo.appcore.presentation.di

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState
import org.koin.core.definition.Definition
import org.koin.dsl.ScopeDSL

/**
 * Registers a [HexagonBaseContentLayout] in the current Koin scope.
 */
inline fun <
    reified S : HexagonState,
    reified UI : HexagonUIState,
    reified L : HexagonBaseContentLayout<S, UI>,
> ScopeDSL.contentLayoutOf(
    noinline definition: Definition<L> = {
        L::class.java.getDeclaredConstructor().newInstance()
    },
) {
    scoped<HexagonBaseContentLayout<S, UI>>(
        definition = definition as Definition<HexagonBaseContentLayout<S, UI>>,
    )
}

/**
 * Registers a [HexagonContentProvider] in the current Koin scope.
 */
inline fun <
    reified S : HexagonState,
    reified UI : HexagonUIState,
    reified P : HexagonContentProvider<S, UI>,
> ScopeDSL.contentProviderOf(
    noinline definition: Definition<P> = {
        P::class.java.getDeclaredConstructor().newInstance()
    },
) {
    scoped<HexagonContentProvider<S, UI>>(
        definition = definition as Definition<HexagonContentProvider<S, UI>>,
    )
}
