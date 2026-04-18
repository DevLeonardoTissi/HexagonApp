//package br.com.leonardo.hexagonapp.ui.components
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import br.com.leonardo.hexagonapp.R
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.LottieConstants
//import com.airbnb.lottie.compose.rememberLottieComposition
//
//@Composable
//fun DevProfileErrorScreen(onTryAgain: () -> Unit) {
//
//    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error))
//    val context = LocalContext.current
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//            LottieAnimation(
//                composition = composition,
//                iterations = LottieConstants.IterateForever,
//                modifier = Modifier.size(200.dp)
//            )
//
//            TypewriterText(texts = listOf(context.getString(R.string.errorMessagingText)))
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { onTryAgain() }) {
//                Text(text = context.getString(R.string.buttonRetryLoadUserInfoText))
//                Icon(
//                    Icons.Default.Refresh,
//                    contentDescription = context.getString(R.string.buttonRetryLoadUserInfoIconDescription)
//                )
//            }
//        }
//    }
//
//}