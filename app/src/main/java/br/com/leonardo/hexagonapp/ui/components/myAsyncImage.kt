package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import br.com.leonardo.hexagonapp.R
import coil.compose.AsyncImage

@Composable
fun MyAsyncImage(
    model: String?,
    description: String?,
    modifier: Modifier,
) {
    AsyncImage(
        model = model, contentDescription = description, contentScale = ContentScale.Crop,
        error = painterResource(id = R.drawable.error),
        placeholder = painterResource(id = R.drawable.profile), modifier = modifier,
    )
}