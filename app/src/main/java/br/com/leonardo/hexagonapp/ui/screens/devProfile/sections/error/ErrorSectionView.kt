package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error.components.TypewriterText
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

class ErrorSectionView : HexagonSectionView<ErrorSectionRender>() {

    @Composable
    override fun Show(render: ErrorSectionRender, onActions: (HexagonAction) -> Unit) {
        with(render) {

            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(200.dp)
                )

                TypewriterText(texts = errorTexts)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onActions(DevProfileActions.Load) }) {
                    Text(text = buttonText)
                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = iconRefreshDescription
                    )
                }
            }
        }
    }
}