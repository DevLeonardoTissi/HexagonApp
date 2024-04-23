package br.com.leonardo.hexagonapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.UUID

class HomeScreenViewModel(val repository: PersonalProfileRepository) : ViewModel() {

    val activesList: Flow<List<PersonalProfile>> = repository.getActives()

    fun add() {
        viewModelScope.launch {
            repository.add(
                PersonalProfile(
                    cpf = UUID.randomUUID().toString(),
                    name = "Leo",
                    city = "Pirapeting",
                    dateOfBirth = "07/10/1999",
                    photo = "https://img.freepik.com/fotos-premium/sombra-de-planta-de-casa-em-uma-parede-branca-espaco-para-texto-sombra-de-folhas-de-palmeira_343275-1148.jpg"
                )
            )
        }
    }

}