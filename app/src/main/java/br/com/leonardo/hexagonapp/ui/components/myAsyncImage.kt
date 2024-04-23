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
    contentScale: ContentScale
) {
    AsyncImage(
        model = model, contentDescription = description, contentScale = contentScale,
        error = painterResource(id = R.drawable.error),
        placeholder = painterResource(id = R.drawable.profile), modifier = modifier,
    )
}