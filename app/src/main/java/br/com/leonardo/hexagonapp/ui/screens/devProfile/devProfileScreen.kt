package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.components.DevProfileErrorScreen
import br.com.leonardo.hexagonapp.ui.components.DevProfileShimmerScreen
import br.com.leonardo.hexagonapp.ui.components.ModalBottomSheetShareDevProfile
import br.com.leonardo.hexagonapp.ui.components.SubComposeAsyncImage
import br.com.leonardo.hexagonapp.utils.DevUiProfileState
import br.com.leonardo.hexagonapp.utils.extensions.context.copyToClipboard
import br.com.leonardo.hexagonapp.utils.extensions.context.goToUri
import br.com.leonardo.hexagonapp.utils.extensions.context.shareSheetText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevProfileScreen(uiState: DevProfileUiState) {

    val context = LocalContext.current

    when (uiState.state) {
        DevUiProfileState.Loading -> {
            DevProfileShimmerScreen()
        }

        DevUiProfileState.Error -> {
            DevProfileErrorScreen(onTryAgain = {
                uiState.onLoadUserInfo()
            })
        }

        DevUiProfileState.Success -> {

            PullToRefreshBox(
                isRefreshing = uiState.refreshing,
                onRefresh = { uiState.refreshingPerform() },
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    uiState.userProfile?.let { userProfile ->
                        Box(modifier = Modifier.fillMaxWidth()) {
                            SubComposeAsyncImage(
                                model = userProfile.avatar_url,
                                description = context.getString(R.string.devProfileImageDescription),
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
                                onClick = { uiState.changeVisibilityBottomSheetShareProfile(true) },
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
                                    contentDescription = context.getString(R.string.shareProfileIconDescription),
                                    tint = Color.White
                                )
                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(100.dp))
                    Text(text = context.getString(R.string.repositoriesTitle), fontSize = 20.sp)
                    LazyRow {
                        uiState.repositories?.let { repositoriesNonNull ->
                            items(repositoriesNonNull) { repository ->
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

                                            repository.name?.let {
                                                Text(
                                                    text = it,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis,
                                                    color = MaterialTheme.colorScheme.secondary,
                                                    modifier = Modifier.padding(8.dp)
                                                )
                                            }

                                            HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                                            Spacer(modifier = Modifier.height(20.dp))
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(100.dp),
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                repository.description?.let {
                                                    Text(
                                                        text = it,
                                                        color = MaterialTheme.colorScheme.secondary,
                                                        maxLines = 4,
                                                        overflow = TextOverflow.Ellipsis
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(20.dp))
                                            repository.html_url?.let {
                                                Button(onClick = { context.goToUri(it) }) {
                                                    Text(text = context.getString(R.string.repositoryURItext))
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (uiState.showBottomSheetShareProfile) {
                    ModalBottomSheetShareDevProfile(
                        qrCodeText = context.getString(R.string.LinkedinProfileUrl),
                        onDismissRequest = { uiState.changeVisibilityBottomSheetShareProfile(false) },
                        onclickShareButton = {
                            with(context) {
                                shareSheetText(
                                    R.string.shareSheetProfileUrlTile,
                                    getString(R.string.LinkedinProfileUrl)
                                )
                            }
                        },
                        onClickCopyButton = {
                            with(context) {
                                copyToClipboard(
                                    R.string.copyToClipboardToastMessageLabel,
                                    getString(R.string.LinkedinProfileUrl),
                                    R.string.copyToClipboardToastMessage
                                )
                            }
                        })
                }
            }
        }
    }
}