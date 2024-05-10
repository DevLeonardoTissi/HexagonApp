//package br.com.leonardo.hexagonapp.ui.components
//
//import android.content.Context
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//import br.com.leonardo.hexagonapp.R
//
//@Composable
//fun DialogWithImage(
//    onDismissRequest: () -> Unit,
//    onConfirmation: (newUrl: String?) -> Unit,
//    url: String?,
//    iconId: Int,
//    iconDescription: String,
//    labelText: String,
//    placeholderText: String,
//    text: String,
//    keyboardOptions: KeyboardOptions? = null,
//    context: Context
//) {
//    Dialog(onDismissRequest = { onDismissRequest() }) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            shape = RoundedCornerShape(16.dp),
//        ) {
//            Column(
//                modifier = Modifier
//                    .wrapContentHeight()
//                    .padding(16.dp)
//                    .verticalScroll(rememberScrollState()),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//
//                var newUrl by remember { mutableStateOf(url) }
//
//                if (!newUrl.isNullOrBlank()) {
//                    MyAsyncImage(
//                        model = newUrl,
//                        description = null,
//                        modifier = Modifier, contentScale = ContentScale.Fit
//                    )
//                }
//
//
//                Text(
//                    text = text,
//                    modifier = Modifier.padding(16.dp),
//                    textAlign = TextAlign.Center,
//
//                    )
//
//                SearchTextField(
//                    searchText = newUrl,
//                    onSearchChange = { newUrl = it },
//                    modifier = Modifier
//                        .height(80.dp)
//                        .padding(10.dp),
//                    iconId = iconId,
//                    iconDescription = iconDescription,
//                    labelText = labelText,
//                    placeholderText = placeholderText,
//                    keyboardOptions = keyboardOptions
//                )
//
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center,
//                ) {
//                    TextButton(
//                        onClick = { onDismissRequest() },
//                        modifier = Modifier.padding(8.dp),
//                    ) {
//                        Text(context.getString(R.string.commonDismiss))
//                    }
//                    TextButton(
//                        onClick = { onConfirmation(newUrl) },
//                        modifier = Modifier.padding(8.dp),
//                    ) {
//                        Text(context.getString(R.string.commonConfirm))
//                    }
//                }
//            }
//        }
//    }
//}