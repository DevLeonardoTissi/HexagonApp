package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.R

@Composable
fun PersonalProfileLayout(
    id: String,
    name: String,
    cpf: String,
    dateOfBirth: String,
    photo: String?,

    onClickItem: (profileId: String) -> Unit
) {
    val context = LocalContext.current

    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
        modifier = Modifier.padding(15.dp),
        onClick = { onClickItem(id) }
    ) {
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Blue), verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Gray), verticalAlignment = Alignment.CenterVertically
            ) {
                SubComposeAsyncImage(
                    model = photo,
                    description = context.getString(R.string.personalProfileImageDescription),
                    modifier = Modifier.size(150.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        text = name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = context.getString(R.string.personalProfileDateOfBirthDescription),
                            tint = Color.White
                        )
                        Text(
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = dateOfBirth,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 5.dp),
                            color = Color.White
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = context.getString(R.string.personalProfileCPFDescription),
                            tint = Color.White
                        )
                        Text(
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = cpf,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 5.dp),
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}