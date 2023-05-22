package com.fggc.asistentecrud.presentation.update_asistentes

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.asistentecrud.presentation.asistentes.AsistentesViewModel
import com.fggc.asistentecrud.presentation.update_asistentes.components.UpdateMascotaContent
import com.fggc.asistentecrud.presentation.update_asistentes.components.UpdateMascotaTopBar

@Composable
fun UpdateAsistenteScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    asistenteId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getAsistente(asistenteId)
    }
    Scaffold(
        topBar = {
            UpdateMascotaTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateMascotaContent(
                padding = padding,
                asistente = viewModel.asistente,
                updateNombreCompleto = { nombre->
                    viewModel.updateNombreCompleto(nombre)
                },
                updateTelefono = { telefono->
                    viewModel.updateTelefono(telefono)
                },
                updateCorreo = { correo->
                    viewModel.updateCorreo(correo)
                },
                updateAsistente = { asistente ->
                    viewModel.updateAsistente(asistente)
                },
                navigateBack = navigateBack
            )
        }
    )
}