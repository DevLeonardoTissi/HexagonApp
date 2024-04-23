package br.com.leonardo.hexagonapp.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.hexagonapp.ui.components.PersonlProfileList
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel = koinViewModel()) {

    val personalProfileList by homeScreenViewModel.activesList.collectAsStateWithLifecycle(null)


    PersonlProfileList(list = personalProfileList, onCLickItem = {

    })

//    Button(modifier = Modifier.size(200.dp), onClick = { homeScreenViewModel.add()}) {
//
//    }

}