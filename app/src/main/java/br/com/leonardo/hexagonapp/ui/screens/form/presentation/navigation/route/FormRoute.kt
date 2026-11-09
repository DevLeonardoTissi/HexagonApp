package br.com.leonardo.hexagonapp.ui.screens.form.presentation.navigation.route

import br.com.leonardo.appcore.presentation.navigator.Route
import kotlinx.serialization.Serializable

@Serializable
data class FormRoute(
    val profileId: String? = null,
) : Route
