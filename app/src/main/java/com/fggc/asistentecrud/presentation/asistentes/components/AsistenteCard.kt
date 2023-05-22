package com.fggc.asistentecrud.presentation.asistentes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.asistentecrud.domain.model.Asistente

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AsistenteCard(
    asistente: Asistente,
    deleteAsistente: () -> Unit,
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text(asistente.nombre_completo)
                Text(asistente.correo)
                Text(asistente.telefono)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            UpdateIcon (
                asistente = asistente,
                navigateToUpdateAsistenteScreen =
                    navigateToUpdateAsistenteScreen
            )
            DeleteIcon(
                deleteAsistente = deleteAsistente
            )
        }
    }
}
