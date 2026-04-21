package br.com.leonardo.hexagonapp.ui.screens.form.sections.userPhotoPicker

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.components.SubComposeAsyncImage
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormActions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView

class UserPhotoPickerView : HexagonSectionView<UserPhotoPickerSectionRender>(
) {

    @Composable
    override fun Show(render: UserPhotoPickerSectionRender, onActions: (HexagonAction) -> Unit) {
        Box(modifier = Modifier.fillMaxWidth()) {

            val pickMedia =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
                    uri?.let {
                        onActions(PersonalProfileFormActions.InsertPhoto(it.toString()))
                    }
                }

            SubComposeAsyncImage(
                model = render.photoURI,
                description = stringResource(R.string.userProfileDescription),
                modifier = Modifier
                    .size(200.dp)
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
                    .border(
                        BorderStroke(
                            2.dp,
                            color = MaterialTheme.colorScheme.primary
                        ), CircleShape
                    )
            )

            IconButton(
                onClick = { pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 50.dp, x = 50.dp)
                    .size(50.dp)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                    .border(
                        BorderStroke(
                            2.dp,
                            color = Color.White
                        ), CircleShape
                    )
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = stringResource(R.string.updatePhotoDescriptionButton),
                    tint = Color.White
                )
            }
        }
    }
}