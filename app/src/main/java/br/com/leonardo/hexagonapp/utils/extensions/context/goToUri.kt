package br.com.leonardo.hexagonapp.utils.extensions.context

import android.content.Context
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import br.com.leonardo.hexagonapp.R

fun Context.goToUri(address: String) {

    val uri = address.toUri()
    CustomTabsIntent.Builder().apply {
        setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(ContextCompat.getColor(this@goToUri, R.color.black))
                .build()
        )
        setStartAnimations(this@goToUri, R.anim.enter_from_bottom, R.anim.exit_to_bottom)
        setExitAnimations(this@goToUri, R.anim.exit_to_bottom, R.anim.enter_from_bottom)
        setUrlBarHidingEnabled(true)
        setShowTitle(true)
    }.build().run {
        launchUrl(this@goToUri, uri)
    }
}