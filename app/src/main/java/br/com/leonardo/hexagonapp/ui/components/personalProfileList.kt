package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.ui.theme.customRed
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalProfileList(
    list: List<PersonalProfile>?,
    onCLickItem: (profileID: String) -> Unit,
    onDelete: (profile: PersonalProfile) -> Unit
) {
    val context = LocalContext.current
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(null) {
        delay(200)
        visible = !visible
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { -it })
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            list?.let { list ->
                LazyColumn {
                    items(list, key = { it.id }) { profile ->
                        val swipeToDismissBoxState = rememberSwipeToDismissBoxState()

                        LaunchedEffect(swipeToDismissBoxState.currentValue) {
                            if (swipeToDismissBoxState.currentValue === SwipeToDismissBoxValue.EndToStart) {
                                onDelete(profile)
                            }
                        }

                        SwipeToDismissBox(state = swipeToDismissBoxState, backgroundContent = {
                            when (swipeToDismissBoxState.dismissDirection) {
                                SwipeToDismissBoxValue.StartToEnd -> {}
                                SwipeToDismissBoxValue.EndToStart -> {

                                    Box(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .background(customRed, RoundedCornerShape(16.dp))
                                            .fillMaxSize()

                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .align(Alignment.CenterEnd)
                                                .padding(16.dp)
                                        ) {
                                            Text(
                                                text = context.getString(R.string.swipeToDismissBoxLabelDelete),
                                                color = Color.White,
                                                modifier = Modifier
                                                    .align(Alignment.CenterHorizontally)
                                            )
                                            Icon(
                                                Icons.Default.Delete,
                                                contentDescription = context.getString(R.string.swipeToDismissBoxIconDescriptionDelete),
                                                modifier = Modifier
                                                    .align(Alignment.CenterHorizontally)
                                            )
                                        }
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
                                onClickItem = { profileId ->
                                    onCLickItem(profileId)
                                }
                            )
                        }
                    }
                }
            }
        }
    }


}