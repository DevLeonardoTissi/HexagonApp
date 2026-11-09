package br.com.leonardo.appcore.domain.usecase

interface BatteryMonitorUseCase {
    fun monitor(batteryLevelChange: (Boolean) -> Unit)

    fun registerReceiver()

    fun unregisterReceiver()
}
