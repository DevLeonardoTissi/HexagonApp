package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SearchTextField(
    searchText: String?,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String,
    placeholderText: String,
    icon: ImageVector,
    iconDescription: String?,
    keyboardOptions: KeyboardOptions? = KeyboardOptions(keyboardType = KeyboardType.Text),
    readonly : Boolean? = false
) {
    OutlinedTextField(
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
//                tint = md_theme_light_primary
            )
        },
        label = {
            Text(text = labelText)
        },
        placeholder = {
            Text(placeholderText)
        },
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}