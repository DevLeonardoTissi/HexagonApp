package br.com.leonardo.hexagonapp.broadcasReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryStatusBroadcastReceiver(private val onBatteryLowChanged: (Boolean) -> Unit): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
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