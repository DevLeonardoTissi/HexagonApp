package br.com.leonardo.appcore.domain.usecase

/**
 * Use case interface for monitoring device battery level changes and managing broadcast receivers.
 */
interface BatteryMonitorUseCase {
    /**
     * Starts monitoring battery level changes.
     *
     * @param batteryLevelChange Callback invoked with `true` when battery is low, `false` otherwise.
     */
    fun monitor(batteryLevelChange: (Boolean) -> Unit)

    /**
     * Registers the battery status broadcast receiver.
     */
    fun registerReceiver()

    /**
     * Unregisters the battery status broadcast receiver.
     */
    fun unregisterReceiver()
}
