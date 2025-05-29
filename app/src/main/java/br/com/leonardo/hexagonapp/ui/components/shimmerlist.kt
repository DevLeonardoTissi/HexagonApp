package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerList(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            // .horizontalScroll(scrollState)
            .padding(16.dp)
    ) {
        repeat(5) {
            Surface(
                color = Color(0xFF9E9E9E),
                shape = RoundedCornerShape(15.dp),
                shadowElevation = 4.dp,
                modifier = modifier.padding(15.dp)
            ) {
                Row(modifier = Modifier.padding(start = 15.dp)) {
                    Column(
                        modifier = Modifier
                            .width(300.dp)
                            .height(250.dp)
                            .background(Color(0xFFE0E0E0))
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ShimmerPlaceholder(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .height(20.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            paddingModifier = Modifier.padding(8.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        HorizontalDivider(color = Color(0xFF9E9E9E))

                        Spacer(modifier = Modifier.height(20.dp))

                        repeat(3) {
                            ShimmerPlaceholder(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .height(15.dp)
                                    .clip(RoundedCornerShape(4.dp)),
                                paddingModifier = Modifier.padding(vertical = 4.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        ShimmerPlaceholder(
                            modifier = Modifier
                                .width(150.dp)
                                .height(36.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                    }
                }
            }
        }
    }


}
