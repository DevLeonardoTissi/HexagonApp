package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.ui.components.SubComposeAsyncImage
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView

class UserSectionView : HexagonSectionView<UserSectionRender>() {

    @Composable
    override fun Show(render: UserSectionRender, onActions: (HexagonAction) -> Unit) {

        with(render) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                userProfile?.let { userProfile ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        SubComposeAsyncImage(
                            model = userProfile.avatarUrl,
                            description = userImageDescription,
                            modifier = Modifier
                                .size(200.dp)
                                .offset(y = 50.dp)
                                .align(Alignment.Center)
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
                                .combinedClickable(
                                    onClick = {},
                                    onLongClick = {}
                                )
                        )

                        IconButton(
                            onClick = {
                                onActions(
                                    DevProfileActions.ChangeVisibilityBottomSheetShare(
                                        true
                                    )
                                )
                            },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .align(Alignment.BottomCenter)
                                .offset(y = 50.dp, x = 50.dp)
                                .size(50.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                )
                                .border(
                                    BorderStroke(
                                        2.dp,
                                        color = Color.White
                                    ), CircleShape
                                )
                        ) {
                            Icon(
                                Icons.Default.Share,
                                contentDescription = shareIconDescription,
                                tint = Color.White
                            )
                        }

                    }
                }
            }

        }

    }

}