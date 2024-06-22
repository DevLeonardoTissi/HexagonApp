package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.components.MyAsyncImage
import br.com.leonardo.hexagonapp.ui.components.TypewriterText
import br.com.leonardo.hexagonapp.utils.DevUiProfileState
import br.com.leonardo.hexagonapp.utils.goToUri
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun DevProfileScreen(uiState: DevProfileUiState) {

    val context = LocalContext.current
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error))


    when (uiState.state) {
        DevUiProfileState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    TypewriterText(texts = listOf(context.getString(R.string.loadingMessagingText)))
                }
            }
        }

        DevUiProfileState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.size(200.dp)
                    )

                    TypewriterText(texts = listOf(context.getString(R.string.errorMessagingText)))
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { uiState.onLoadUserInfo() }) {
                        Text(text = context.getString(R.string.buttonRetryLoadUserInfoText))
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = context.getString(R.string.buttonRetryLoadUserInfoIconDescription)
                        )
                    }
                }
            }
        }

        DevUiProfileState.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                MyAsyncImage(
                    model = uiState.userProfile.avatar_url,
                    description = context.getString(R.string.devProfileImageDescription),
                    modifier = Modifier
                        .size(200.dp)
                        .offset(y = 50.dp)
                        .clip(shape = CircleShape)
                        .border(
                            BorderStroke(
                                2.dp,
                                brush = Brush.verticalGradient(
                                    listOf(
                                        MaterialTheme.colorScheme.secondaryContainer,
                                        MaterialTheme.colorScheme.secondary
                                    )
                                )
                            ), CircleShape
                        )
                )

                Spacer(modifier = Modifier.height(100.dp))

                Text(text = context.getString(R.string.repositoriesTitle), fontSize = 20.sp)
                LazyRow {
                    items(uiState.repositories) { repositories ->
                        Surface(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(15.dp),
                            shadowElevation = 4.dp,
                            modifier = Modifier.padding(15.dp),
                        ) {
                            Row(modifier = Modifier.padding(start = 15.dp)) {
                                Column(
                                    modifier = Modifier
                                        .width(300.dp)
                                        .height(250.dp)
                                        .background(MaterialTheme.colorScheme.primaryContainer)
                                        .padding(10.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally

                                ) {
                                    Text(
                                        text = repositories.name,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.padding(8.dp)
                                    )
                                    HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = repositories.description,
                                            color = MaterialTheme.colorScheme.secondary,
                                            maxLines = 4,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Button(onClick = { goToUri(repositories.html_url, context) }) {
                                        Text(text = context.getString(R.string.repositoryURItext))
                                    }
//                                    ClickableText(text = AnnotatedString(context.getString(R.string.repositoryURItext))) {
//                                        goToUri(repositories.html_url, context)
//                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}