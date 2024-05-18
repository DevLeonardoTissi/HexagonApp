package br.com.leonardo.hexagonapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.di.modules.viewModelModule
import br.com.leonardo.hexagonapp.model.Settings
import br.com.leonardo.hexagonapp.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(private val repository: SettingsRepository) : ViewModel() {

    val settings: Flow<Settings> = repository.searchSettings()

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    private fun updateSettings(settings: Settings) {
        viewModelScope.launch {
            repository.updateSettings(settings)
        }
    }

    private fun updateDrawer(){
        viewModelScope.launch {
            if (_uiState.value.drawerState.isOpen) {
                _uiState.value.drawerState.close()
            } else {
                _uiState.value.drawerState.open()
            }
        }
    }

    init {
        viewModelScope.launch {
            settings.collect { settings ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isDarkMode = settings.darkMode,
                        onDarkModeChange = { isDarkMode ->
                            updateSettings(Settings(darkMode = isDarkMode))
                        },
                        onShowBottomSheetDialogInfoAndConfig = { showBottomSheetDialogInfoAndConfig ->
                            _uiState.value =
                                _uiState.value.copy(showBottomSheetDialogInfoAndConfig = showBottomSheetDialogInfoAndConfig)
                        },
                        updateDrawer = {
                                updateDrawer()


                        }
                    )
                }
            }
        }
    }
}