package com.fggc.asistentecrud.presentation.asistentes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fggc.asistentecrud.core.Constants
import com.fggc.asistentecrud.domain.model.Asistente


@Composable
fun UpdateIcon(
    asistente: Asistente,
    navigateToUpdateAsistenteScreen: (mascotaId: Int) -> Unit
){
    IconButton(
        onClick = { navigateToUpdateAsistenteScreen(asistente.id) }
    ) {
        Icon(imageVector = Icons.Default.Edit,
            contentDescription = Constants.UPDATE,
            tint = Color.Blue
        )
    }
}