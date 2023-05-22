package com.fggc.asistentecrud.presentation.asistentes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fggc.asistentecrud.core.Constants.Companion.DELETE_ASISTENTE

@Composable
fun DeleteIcon(
    deleteAsistente: () -> Unit
){
    IconButton(onClick =  deleteAsistente ) {
        Icon(imageVector = Icons.Default.Delete,
            contentDescription = DELETE_ASISTENTE,
            tint = Color.Red
        )
    }
}