package com.fggc.asistentecrud.presentation.update_asistentes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.fggc.asistentecrud.core.Constants.Companion.UPDATE_ASISTENTE_SCREEN

@Composable
fun UpdateMascotaTopBar (
    navigateBack: () -> Unit
){
    TopAppBar(
        title = {
            Text(UPDATE_ASISTENTE_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null)
            }
        }
    )
}