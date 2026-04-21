package br.com.leonardo.hexagonapp.ui.screens.form.sections.form

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.components.AnimatedAlertDialogWithConfirmButton
import br.com.leonardo.hexagonapp.ui.components.SearchTextField
import br.com.leonardo.hexagonapp.ui.components.SubComposeAsyncImage
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormActions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView
import java.time.LocalDate

class FormSectionView : HexagonSectionView<FormSectionRender>() {

    @Composable
    override fun Show(render: FormSectionRender, onActions: (HexagonAction) -> Unit) {

        val datePickerState = rememberDatePickerState(
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    return utcTimeMillis <= System.currentTimeMillis()
                }

                override fun isSelectableYear(year: Int): Boolean {
                    return year <= LocalDate.now().year
                }
            }
        )


        val focusManager = LocalFocusManager.current


        Spacer(modifier = Modifier.height(80.dp))

        SearchTextField(
            iconDescription = stringResource(R.string.profileIcon),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp),
            labelText = stringResource(R.string.inputNameLabel),
            placeholderText = stringResource(R.string.inputNamePlaceHolder),
            onSearchChange = { onActions(PersonalProfileFormActions.FieldNameChanged(it)) },
            icon = Icons.Default.Person,
            searchText = render.name,
            inError = render.fieldNameError
        )

        SearchTextField(
            iconDescription = stringResource(R.string.cpfIcon),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp),
            labelText = stringResource(R.string.inputCpfLabel),
            placeholderText = stringResource(R.string.inputCpfPlaceHolder),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onSearchChange = { input ->
                val onlyDigits = input.filter { it.isDigit() }
                if (input.length <= 11) {
                    onActions(PersonalProfileFormActions.FieldCPFChanged(onlyDigits))
                }
            },
            icon = Icons.Default.Lock,
            searchText = render.cpf,
            inError = render.fieldCPFError,
            visualTransformation = cpfVisualTransformation()
        )

        SearchTextField(
            iconDescription = stringResource(R.string.locationIcon),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp),
            labelText = stringResource(R.string.inputLocationLabel),
            placeholderText = stringResource(R.string.inputLocationPlaceHolder),
            onSearchChange = { onActions(PersonalProfileFormActions.FieldCityChanged(it)) },
            icon = Icons.Default.LocationOn,
            searchText = render.city,
            inError = render.fieldCityError
        )

        SearchTextField(
            iconDescription = stringResource(R.string.dateIcon),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp)
                .onFocusEvent {
                    if (it.isFocused) {
                        onActions(PersonalProfileFormActions.InputDateClick)
                        focusManager.clearFocus(force = true)
                    }
                },
            labelText = stringResource(R.string.inputDateOfBirthLabel),
            placeholderText = stringResource(R.string.inputDateOfBirthPlaceHolder),
            onSearchChange = { },
            icon = Icons.Default.DateRange,
            searchText = render.dateOfBirthPresentation,
            readonly = true,
            inError = render.fieldDateOfBirthError
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(text = stringResource(R.string.switchOptionActiveProfileLabelDescription))
            Spacer(modifier = Modifier.width(20.dp))
            Switch(
                checked = render.active,
                onCheckedChange = {
                    onActions(PersonalProfileFormActions.OnSwitchChange(it))
                },
                modifier = Modifier.semantics {
                    contentDescription =
                        " LocalContext.current.getString(R.string.switchOptionActiveProfileDescription)"
                })
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (render.showDatePickerDialog) {
            DatePickerDialog(
                properties = DialogProperties(),
                onDismissRequest = { onActions(PersonalProfileFormActions.DismissDatePicker) },
                confirmButton = {
                    Button(
                        onClick = {
                            datePickerState
                                .selectedDateMillis?.let { millis ->
                                    onActions(
                                        PersonalProfileFormActions.FieldDateOfBirthChangedChanged(
                                            millis
                                        )
                                    )
                                }
                            onActions(PersonalProfileFormActions.DismissDatePicker)
                        }) {
                        Text(text = stringResource(R.string.dataPickerConfirmButtonText))
                    }
                }) {
                DatePicker(state = datePickerState)
            }
        }


        if (render.showConfirmDialog) {
            AnimatedAlertDialogWithConfirmButton(
                onConfirmation = {
                    onActions(PersonalProfileFormActions.ModalConfirmClick)

                },
                onDismissRequest = { onActions(PersonalProfileFormActions.ModalDismiss) },
                rawRes = R.raw.android,
                text = stringResource(R.string.textAlertDialogConfirm),
                title = stringResource(R.string.titleAlertDialogConfirm)
            )
        }
    }


    private fun cpfVisualTransformation(): VisualTransformation {
        return VisualTransformation { text ->
            val digits = text.text.filter { it.isDigit() }

            val formatted = buildString {
                for (i in digits.indices) {
                    append(digits[i])
                    if (i == 2 || i == 5) append(".")
                    if (i == 8) append("-")
                }
            }

            val offsetMapping = object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    var transformed = offset
                    if (offset > 2) transformed += 1
                    if (offset > 5) transformed += 1
                    if (offset > 8) transformed += 1
                    return transformed.coerceAtMost(formatted.length)
                }

                override fun transformedToOriginal(offset: Int): Int {
                    var original = offset
                    if (offset > 3) original -= 1
                    if (offset > 7) original -= 1
                    if (offset > 11) original -= 1
                    return original.coerceAtMost(digits.length)
                }
            }

            TransformedText(AnnotatedString(formatted), offsetMapping)
        }
    }
}