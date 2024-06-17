package br.com.leonardo.hexagonapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconSecondaryColor(imageVector: ImageVector, contentDescription:String){
    Icon(imageVector = imageVector, contentDescription = contentDescription, tint = MaterialTheme.colorScheme.secondary)

}