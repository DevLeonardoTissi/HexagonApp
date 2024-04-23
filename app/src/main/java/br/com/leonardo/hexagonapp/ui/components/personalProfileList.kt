package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.leonardo.hexagonapp.model.PersonalProfile

@Composable
fun PersonlProfileList(list:List<PersonalProfile>?, onCLickItem: () ->Unit = {}){
    
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxHeight()
        ,
        horizontalAlignment = Alignment.CenterHorizontally){

        list?.let {list ->
            LazyColumn {
                items(list){profile->
                    PersonalProfileLayout(
                        name = profile.name,
                        city =  profile.city,
                        dateOfBirth = profile.dateOfBirth ,
                        cpf = profile.cpf,
                        active = profile.active ?: false,
                        photo =  profile.photo,
                        onClickItem = onCLickItem
                    )
                }
            }


        }
        

        
    }
    
    
   
}