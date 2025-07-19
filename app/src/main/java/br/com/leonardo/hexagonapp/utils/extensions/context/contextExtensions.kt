package br.com.leonardo.hexagonapp.utils.extensions.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import br.com.leonardo.hexagonapp.R

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(
        this,
        message,
        duration
    ).show()
}

fun Context.shareSheetText(titleResId: Int, uri: String) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, uri)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, this.getString(titleResId))
    this.startActivity(shareIntent)
}

fun Context.copyToClipboard(labelResId: Int, text: String, toastMessageResId: Int) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(getString(labelResId), text)
    clipboard.setPrimaryClip(clip)
    this.toast(getString(toastMessageResId))
}

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


