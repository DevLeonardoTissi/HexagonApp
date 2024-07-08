package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.R
import coil.compose.SubcomposeAsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SubComposeAsyncImage(
    model: String?,
    description: String?,
    modifier: Modifier,
) {
    SubcomposeAsyncImage(
        model = if(model.isNullOrBlank()) R.drawable.placeholder else model,
        contentDescription = description,
        loading = {
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.load))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(150.dp)
                )
            }
        },
        error = {
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.load_error))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier.size(80.dp)
                )
            }
        },
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}