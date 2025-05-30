package br.com.leonardo.hexagonapp.utils.extensions.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast

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


