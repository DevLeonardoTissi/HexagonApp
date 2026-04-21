//package br.com.leonardo.hexagonapp.ui.screens.form
//
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.PickVisualMediaRequest
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Check
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Button
//import androidx.compose.material3.DatePicker
//import androidx.compose.material3.DatePickerDialog
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.SelectableDates
//import androidx.compose.material3.Switch
//import androidx.compose.material3.Text
//import androidx.compose.material3.rememberDatePickerState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.focus.onFocusEvent
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.semantics.contentDescription
//import androidx.compose.ui.semantics.semantics
//import androidx.compose.ui.text.AnnotatedString
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.OffsetMapping
//import androidx.compose.ui.text.input.TransformedText
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.DialogProperties
//import br.com.leonardo.hexagonapp.R
//import br.com.leonardo.hexagonapp.ui.screens.form.sections.form.components.AnimatedAlertDialogWithConfirmButton
//import br.com.leonardo.hexagonapp.ui.screens.form.sections.form.components.SearchTextField
//import br.com.leonardo.hexagonapp.ui.components.SubComposeAsyncImage
//import java.time.LocalDate
//import androidx.compose.ui.res.stringResource
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PersonalProfileFormScreenn(
//    uiState: PersonalProfileFormState, onPopBackStack: () -> Unit
//) {
//    val context = LocalContext.current
//
//
//
//
//
//
//
//    if (uiState.showConfirmDialog) {
//        AnimatedAlertDialogWithConfirmButton(
//            onConfirmation = {
//                uiState.onSave()
//                uiState.onShowConfirmDialog(false)
//                onPopBackStack()
//
//            },
//            onDismissRequest = { uiState.onShowConfirmDialog(false) },
//            rawRes = R.raw.android,
//            text = stringResource(R.string.textAlertDialogConfirm),
//            title = stringResource(R.string.titleAlertDialogConfirm)
//        )
//    }
//
//
//}
//
//
//
