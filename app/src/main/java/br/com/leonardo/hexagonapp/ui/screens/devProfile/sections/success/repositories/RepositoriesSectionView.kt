package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories.components.ModalBottomSheetShareDevProfile
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.hexagonapp.utils.extensions.context.copyToClipboard
import br.com.leonardo.hexagonapp.utils.extensions.context.goToUri
import br.com.leonardo.hexagonapp.utils.extensions.context.shareSheetText
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView

class RepositoriesSectionView : HexagonSectionView<RepositoriesSectionRender>() {

    @Composable
    override fun Show(render: RepositoriesSectionRender, onActions: (HexagonAction) -> Unit) {
        val context = LocalContext.current
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(100.dp))
            Text(text = render.title, fontSize = 20.sp)

            LazyRow {
                render.repositoriesList?.let { repositoriesNonNull ->
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

                                    repository.name.let {
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
                                        repository.description.let {
                                            Text(
                                                text = it,
                                                color = MaterialTheme.colorScheme.secondary,
                                                maxLines = 4,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))
                                    repository.htmlUrl.let {
                                        Button(onClick = { context.goToUri(it) }) {
                                            Text(text = stringResource(R.string.repositoryURItext))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (render.showBottomSheetShareProfile) {
                ModalBottomSheetShareDevProfile(
                    qrCodeText = stringResource(R.string.LinkedinProfileUrl),
                    onDismissRequest = {
                        onActions(
                            DevProfileActions.ChangeVisibilityBottomSheetShare(
                                false
                            )
                        )
                    },
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