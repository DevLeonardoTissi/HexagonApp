package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.confirmButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionView
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormActions

class ConfirmButtonSectionView : HexagonSectionView<ConfirmButtonSectionRender>() {
    @Composable
    override fun Show(
        render: ConfirmButtonSectionRender,
        onActions: (HexagonAction) -> Unit,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                enabled = render.isEnable,
                onClick = { onActions(PersonalProfileFormActions.SaveButtonClick) },
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(50.dp),
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = stringResource(R.string.saveIconButton),
                )
            }
        }
    }
}
