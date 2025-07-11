package br.com.leonardo.hexagonapp.usecase

interface BatteryMonitorUseCase {

    fun monitor(batteryLevelChange: (Boolean) -> Unit)
    fun registerReceiver()
    fun unregisterReceiver()
}