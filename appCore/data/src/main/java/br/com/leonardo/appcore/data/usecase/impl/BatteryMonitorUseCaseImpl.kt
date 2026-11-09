package br.com.leonardo.appcore.data.usecase.impl

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import br.com.leonardo.appcore.data.broadcast.BatteryStatusBroadcastReceiver
import br.com.leonardo.appcore.domain.usecase.BatteryMonitorUseCase

class BatteryMonitorUseCaseImpl(
    private val context: Context,
) : BatteryMonitorUseCase {
    private var batteryReceiver: BatteryStatusBroadcastReceiver? = null

    override fun monitor(batteryLevelChange: (Boolean) -> Unit) {
        checkBatteryLevel(batteryLevelChange = { batteryLevelChange(it) })
        batteryReceiver =
            BatteryStatusBroadcastReceiver(onBatteryLowChanged = { batteryLevelChange(it) })
        registerReceiver()
    }

    override fun registerReceiver() {
        val intentFilter =
            IntentFilter().apply {
                addAction(Intent.ACTION_BATTERY_LOW)
                addAction(Intent.ACTION_BATTERY_OKAY)
            }
        context.registerReceiver(batteryReceiver, intentFilter)
    }

    override fun unregisterReceiver() {
        context.unregisterReceiver(batteryReceiver)
    }

    private fun checkBatteryLevel(batteryLevelChange: (Boolean) -> Unit) {
        batteryLevelChange(isBatteryLowNow())
    }

    private fun isBatteryLowNow(): Boolean {
        val intent =
            context.registerReceiver(
                null,
                IntentFilter(Intent.ACTION_BATTERY_CHANGED),
            ) ?: return false

        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level / scale.toFloat()
        return batteryPct <= BATTERY_LOW_THRESHOLD
    }
}

private const val BATTERY_LOW_THRESHOLD = 0.15f
