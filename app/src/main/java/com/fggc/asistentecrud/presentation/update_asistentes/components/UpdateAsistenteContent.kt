package com.fggc.asistentecrud.presentation.update_asistentes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.asistentecrud.core.Constants.Companion.CORREO
import com.fggc.asistentecrud.core.Constants.Companion.NOMBRE_COMPLETO
import com.fggc.asistentecrud.core.Constants.Companion.TELEFONO
import com.fggc.asistentecrud.core.Constants.Companion.UPDATE
import com.fggc.asistentecrud.domain.model.Asistente

@Composable
fun UpdateMascotaContent(
    padding: PaddingValues,
    asistente: Asistente,
    updateNombreCompleto: (nombreCompleto: String) -> Unit,
    updateTelefono: (telefono: String) -> Unit,
    updateCorreo: (correo: String) -> Unit,
    updateAsistente: (asistente:Asistente) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = asistente.nombre_completo,
            onValueChange = {nombre->
                updateNombreCompleto(nombre)
            },
            label = {
                Text(NOMBRE_COMPLETO)
            }
        )

        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.telefono,
            onValueChange = {telefono->
                updateTelefono(telefono)
            },
            label = {
                Text(TELEFONO)
            }
        )

        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.correo,
            onValueChange = {correo->
                updateCorreo(correo)
            },
            label = {
                Text(CORREO)
            }
        )
        Button(
            onClick = {
                updateAsistente(asistente)
                navigateBack()
            }
        ){
            Text(UPDATE)
        }
    }
}






