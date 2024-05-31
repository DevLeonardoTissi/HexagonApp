package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.ui.components.MyAsyncImage
import br.com.leonardo.hexagonapp.ui.components.TypewriterText

@Composable
fun DevProfileScreen(uiState: DevProfileUiState) {

    if (uiState.loadingInfo) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre o CircularProgressIndicator e o TypewriterText
                TypewriterText(texts = listOf("Carregando"))
            }
        }
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                MyAsyncImage(
                    model = uiState.userProfile.avatar_url,
                    description = "",
                    modifier = Modifier
                        .size(200.dp)
                        .offset(y = 50.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                        .border(
                            BorderStroke(
                                2.dp,
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color.White,
                                        Color.Blue
                                    )
                                )
                            ), CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

            }
        }

    }


}