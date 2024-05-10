package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import br.com.leonardo.hexagonapp.model.PersonalProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalProfileList(
    list: List<PersonalProfile>?,
    onCLickItem: (profileID: String) -> Unit,
    onDelete: (profile: PersonalProfile) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        list?.let { list ->
            LazyColumn {
                items(list, key = {
                    it.id
                }) { profile ->
                    val swipeToDismissBoxState = rememberSwipeToDismissBoxState()
                    LaunchedEffect(swipeToDismissBoxState.currentValue) {
                        if (swipeToDismissBoxState.currentValue === SwipeToDismissBoxValue.EndToStart) {
                            onDelete(profile)
                        }
                    }

                    SwipeToDismissBox(state = swipeToDismissBoxState, backgroundContent = {
                       when(swipeToDismissBoxState.dismissDirection){
                           SwipeToDismissBoxValue.StartToEnd -> {}
                           SwipeToDismissBoxValue.EndToStart -> {
                               Box(modifier = Modifier
                                   .fillMaxSize()
                                   .background(Color.Red)){
                                   Text(text = "Remover", modifier = Modifier.align(Alignment.CenterEnd))
                               }
                           }
                           SwipeToDismissBoxValue.Settled -> {}
                       }

                    }, enableDismissFromStartToEnd = false) {
                        PersonalProfileLayout(
                            id = profile.id,
                            name = profile.name,
                            dateOfBirth = profile.dateOfBirth,
                            photo = profile.photo,
                            cpf = profile.cpf,
                            onClickItem = {
                                onCLickItem(it)
                            }
                        )
                    }
                }
            }
        }
    }
}