package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.DEFAULT_IMAGE_URL
import br.com.leonardo.hexagonapp.ui.components.AnimatedAlertDialogWithConfirmButton
import br.com.leonardo.hexagonapp.ui.components.MyAsyncImage
import br.com.leonardo.hexagonapp.ui.components.SearchTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalProfileFormScreen(
    uiState: PersonalProfileFormUiState, navController: NavController
) {
    val context = LocalContext.current

    val datePickerState = rememberDatePickerState()
    val focusManager = LocalFocusManager.current
    val name = uiState.name
    val cpf = uiState.cpf
    val city = uiState.city
    val dateOfBirth = uiState.dateOfBirth
    val photo = uiState.photo
    val active = uiState.active
    val pickMedia =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let { file ->
                uiState.onPhotoChanged(file.toString())
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {

            MyAsyncImage(
                model = if (photo.isNullOrBlank()) DEFAULT_IMAGE_URL else uiState.photo,
                description = context.getString(R.string.userProfileDescription),
                modifier = Modifier
                    .size(200.dp)
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
                    .border(
                        BorderStroke(
                            2.dp,
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.White,
                                    Color.Blue
                                )
                            )
                        ), CircleShape
                    ),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 50.dp, x = 50.dp)
                    .size(50.dp)
                    .background(color = Color.Cyan, shape = CircleShape)

                    .border(
                        BorderStroke(
                            2.dp,
                            color = Color.White
                        ), CircleShape
                    )
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = context.getString(R.string.updatePhotoDescriptionButton),
                    tint = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(80.dp))

        SearchTextField(
            iconDescription = context.getString(R.string.profileIcon),
            modifier = Modifier
                .height(80.dp)
                .padding(10.dp),
            labelText = context.getString(R.string.inputNameLabel),
            placeholderText = context.getString(R.string.inputNamePlaceHolder),
            onSearchChange = { uiState.onNameChanged(it) },
            icon = Icons.Default.Person,
            searchText = name
        )

        SearchTextField(
            iconDescription = context.getString(R.string.cpfIcon),
            modifier = Modifier
                .height(80.dp)
                .padding(10.dp),
            labelText = context.getString(R.string.inputCpfLabel),
            placeholderText = context.getString(R.string.inputCpfPlaceHolder),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onSearchChange = { uiState.onCpfChanged(it) },
            icon = Icons.Default.Lock,
            searchText = cpf
        )

        SearchTextField(
            iconDescription = context.getString(R.string.locationIcon),
            modifier = Modifier
                .height(80.dp)
                .padding(10.dp),
            labelText = context.getString(R.string.inputLocationLabel),
            placeholderText = context.getString(R.string.inputLocationPlaceHolder),
            onSearchChange = { uiState.onCityChanged(it) },
            icon = Icons.Default.LocationOn,
            searchText = city
        )

        SearchTextField(
            iconDescription = context.getString(R.string.dateIcon),
            modifier = Modifier
                .height(80.dp)
                .padding(10.dp)
                .onFocusEvent {
                    if (it.isFocused) {
                        uiState.onShowDatePickerDialog(true)
                        focusManager.clearFocus(force = true)
                    }
                },
            labelText = context.getString(R.string.inputDateOfBirthLabel),
            placeholderText = context.getString(R.string.inputDateOfBirthPlaceHolder),
            onSearchChange = { },
            icon = Icons.Default.DateRange,
            searchText = dateOfBirth,
            readonly = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(text = context.getString(R.string.switchOptionActiveProfileDescription))
            Spacer(modifier = Modifier.width(20.dp))
            Switch(checked = active, onCheckedChange = {
                uiState.onActiveChanged(it)
            })

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { uiState.onShowConfirmDialog(true) }, modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = context.getString(R.string.saveIconButton)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
    }

    if (uiState.showConfirmDialog) {
        AnimatedAlertDialogWithConfirmButton(
            onConfirmation = {
                if (name.isNotBlank() || cpf.isNotBlank() || city.isNotBlank() || dateOfBirth.isNotBlank()) {
                    uiState.onSave()
                    navController.popBackStack()
                    uiState.onShowConfirmDialog(false)
                }
            },
            onDismissRequest = { uiState.onShowConfirmDialog(false) },
            rawRes = R.raw.android,
            text = context.getString(R.string.textAlertDialogConfirm),
            title = context.getString(R.string.titleAlertDialogConfirm)
        )
    }

    if (uiState.showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { uiState.onShowDatePickerDialog(false) },
            confirmButton = {
                Button(
                    onClick = {
                        datePickerState
                            .selectedDateMillis?.let { millis ->
                                uiState.onDateOfBirthChanged(millis.toString())
                            }
                        uiState.onShowDatePickerDialog(false)
                    }) {
                    Text(text = context.getString(R.string.dataPickerConfirmButtonText))
                }
            }) {
            DatePicker(state = datePickerState)
        }
    }

}