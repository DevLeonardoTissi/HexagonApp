package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.unit.dp

@Composable
fun DevProfileShimmerScreen() {

    Column(
        modifier = Modifier.fillMaxSize().keepScreenOn(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ShimmerPlaceholder(
            modifier = Modifier
                .size(200.dp)
                .offset(y = 50.dp)
                .clip(shape = CircleShape)
        )

        Spacer(modifier = Modifier.height(100.dp))
        ShimmerPlaceholder(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(20.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        ShimmerList()
    }

}