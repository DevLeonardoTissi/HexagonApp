package br.com.leonardo.hexagonapp.ui.screens.form.sections.form.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun HexagonTextField(
    searchText: String?,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String,
    placeholderText: String,
    icon: ImageVector,
    iconDescription: String?,
    keyboardOptions: KeyboardOptions? = KeyboardOptions(keyboardType = KeyboardType.Text),
    readonly: Boolean? = false,
    inError: Boolean = false,
    visualTransformation: VisualTransformation? = VisualTransformation.None
) {
    OutlinedTextField(
        isError = inError,
        readOnly = readonly ?: false,
        value = searchText ?: "",
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        modifier = modifier,

        leadingIcon = {
            Icon(
                icon,
                contentDescription = iconDescription,
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        label = {
            Text(text = labelText)
        },
        placeholder = {
            Text(placeholderText)
        },
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = visualTransformation ?: VisualTransformation.None
    )
}