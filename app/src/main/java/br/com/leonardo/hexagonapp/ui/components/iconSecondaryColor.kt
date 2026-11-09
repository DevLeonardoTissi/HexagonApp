package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Reusable icon component tinted with the theme's secondary color scheme.
 *
 * @param imageVector The vector asset to display.
 * @param contentDescription Accessibility description for the icon.
 */
@Composable
fun IconSecondaryColor(
    imageVector: ImageVector,
    contentDescription: String,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = MaterialTheme.colorScheme.secondary,
    )
}
