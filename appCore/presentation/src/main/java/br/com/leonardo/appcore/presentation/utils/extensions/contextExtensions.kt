package br.com.leonardo.appcore.presentation.utils.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import br.com.leonardo.appcore.presentation.R

/**
 * Extension function on [Context] to display a short or long [Toast] message.
 *
 * @param message The text message to display.
 * @param duration The duration of the toast ([Toast.LENGTH_SHORT] or [Toast.LENGTH_LONG]).
 */
fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast
        .makeText(
            this,
            message,
            duration,
        ).show()
}

/**
 * Extension function on [Context] to open an Android system share sheet for sharing plain text.
 *
 * @param titleResId String resource ID for the share chooser title.
 * @param uri The text content to share.
 */
fun Context.shareSheetText(
    titleResId: Int,
    uri: String,
) {
    val sendIntent: Intent =
        Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, uri)
            type = "text/plain"
        }

    val shareIntent = Intent.createChooser(sendIntent, this.getString(titleResId))
    this.startActivity(shareIntent)
}

/**
 * Extension function on [Context] to copy text to the system clipboard and display a confirmation toast.
 *
 * @param labelResId String resource ID for the clip description label.
 * @param text The text to copy.
 * @param toastMessageResId String resource ID for the toast confirmation message.
 */
fun Context.copyToClipboard(
    labelResId: Int,
    text: String,
    toastMessageResId: Int,
) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(getString(labelResId), text)
    clipboard.setPrimaryClip(clip)
    this.toast(getString(toastMessageResId))
}

/**
 * Extension function on [Context] to open a web URI using Chrome Custom Tabs with custom styling and animations.
 *
 * @param address The URL string to open.
 */
fun Context.goToUri(address: String) {
    val uri = address.toUri()
    CustomTabsIntent
        .Builder()
        .apply {
            setDefaultColorSchemeParams(
                CustomTabColorSchemeParams
                    .Builder()
                    .setToolbarColor(ContextCompat.getColor(this@goToUri, R.color.black))
                    .build(),
            )
            setStartAnimations(this@goToUri, R.anim.enter_from_bottom, R.anim.exit_to_bottom)
            setExitAnimations(this@goToUri, R.anim.exit_to_bottom, R.anim.enter_from_bottom)
            setUrlBarHidingEnabled(true)
            setShowTitle(true)
        }.build()
        .run {
            launchUrl(this@goToUri, uri)
        }
}
