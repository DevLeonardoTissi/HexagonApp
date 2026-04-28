package br.com.leonardo.hexagonapp.ui.screens.form.navigation.route

import br.com.leonardo.ui.navigator.Route
import kotlinx.serialization.Serializable

@Serializable
data class FormRoute(val profileId: String? = null) : Route