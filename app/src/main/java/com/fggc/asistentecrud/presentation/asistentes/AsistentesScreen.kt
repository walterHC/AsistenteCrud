package com.fggc.asistentecrud.presentation.asistentes

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTES_SCREEN
import com.fggc.asistentecrud.presentation.asistentes.components.AddAsistenteAlertDialog
import com.fggc.asistentecrud.presentation.asistentes.components.AddAsistenteFloatingActionButton
import com.fggc.asistentecrud.presentation.asistentes.components.AsistentesContent

@Composable
fun AsistenteScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    navigateToUpdateAsistenteScreen: (mascotaId: Int) -> Unit
){
    val asistentes by viewModel.asistentes.collectAsState(
        initial = emptyList() )
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(ASISTENTES_SCREEN)
            })
        },
        content = {
            padding->
            AsistentesContent(
                padding = padding,
                asistentes = asistentes,
                deleteAsistente = {
                    asistente ->
                    viewModel.deleteAsistente(asistente)
                },
                navigateToUpdateAsistenteScreen =
                    navigateToUpdateAsistenteScreen
            )
            AddAsistenteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addAsistente = { asistente->
                    viewModel.addAsistente(asistente)
                }
            )
        },
        floatingActionButton = {
            AddAsistenteFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}