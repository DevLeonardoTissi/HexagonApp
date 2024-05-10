package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.model.Settings
import br.com.leonardo.hexagonapp.repository.SettingsRepository
import kotlinx.coroutines.launch

class AppViewModel(private val repository: SettingsRepository) : ViewModel() {

    val settings = repository.searchSettings()
    fun updateSettings(settings: Settings){
        viewModelScope.launch {
            repository.updateSettings(settings)
        }
    }


}