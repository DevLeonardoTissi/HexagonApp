package br.com.leonardo.hexagonapp.utils

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import br.com.leonardo.hexagonapp.R

fun goToUri(address: String, context: Context) {

    val uri = Uri.parse(address)
    val customTabsIntent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(ContextCompat.getColor(context, R.color.black))
                .build()
        )
        .setStartAnimations(context, R.anim.enter_from_bottom, R.anim.exit_to_bottom)
        .setExitAnimations(context, R.anim.exit_to_bottom, R.anim.enter_from_bottom)
        .setUrlBarHidingEnabled(true)
        .setShowTitle(true)
        .build()

    customTabsIntent.launchUrl(context, uri)

}