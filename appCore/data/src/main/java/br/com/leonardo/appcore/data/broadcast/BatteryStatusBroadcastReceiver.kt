package br.com.leonardo.appcore.data.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * System [BroadcastReceiver] listening for system battery status changes
 * (`Intent.ACTION_BATTERY_LOW` and `Intent.ACTION_BATTERY_OKAY`).
 *
 * @property onBatteryLowChanged Callback invoked when the battery state changes to low (`true`) or okay (`false`).
 */
class BatteryStatusBroadcastReceiver(
    private val onBatteryLowChanged: (Boolean) -> Unit,
) : BroadcastReceiver() {
    /**
     * Receives broadcast intents and triggers the [onBatteryLowChanged] callback based on battery action.
     *
     * @param context The Context in which the receiver is running.
     * @param intent The Intent being received.
     */
    override fun onReceive(
        context: Context?,
        intent: Intent,
    ) {
        when (intent.action) {
            Intent.ACTION_BATTERY_LOW -> {
                onBatteryLowChanged(true)
            }
            Intent.ACTION_BATTERY_OKAY -> {
                onBatteryLowChanged(false)
            }
        }
    }
}
