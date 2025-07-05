package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.theme.HexagonAppTheme
import br.com.leonardo.hexagonapp.utils.generateQrCode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetShareDevProfile(
    qrCodeText: String,
    onDismissRequest: () -> Unit,
    onClickCopyButton: () -> Unit,
    onclickShareButton: () -> Unit
) {

    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    HexagonAppTheme {
        ModalBottomSheet(onDismissRequest = { onDismissRequest() }, sheetState = sheetState) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    text = context.getString(R.string.ModalBottomSheetShareTitleText)
                )

                Spacer(Modifier.height(20.dp))

                Image(
                    bitmap = generateQrCode(qrCodeText).asImageBitmap(),
                    contentDescription = context.getString(R.string.qrCodeDescriptionText),
                    modifier = Modifier.size(220.dp)
                )

                Spacer(Modifier.height(20.dp))

                Button(onClick = {
                    onclickShareButton()
                }) {
                    Text(context.getString(R.string.ModalBottomSheetShareShareButtonText))
                }

                Button(onClick = {
                    onClickCopyButton()
                }) {
                    Text(context.getString(R.string.ModalBottomSheetShareCopyButtonText))
                }

            }
        }
    }
}
