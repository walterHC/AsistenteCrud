package com.fggc.asistentecrud.presentation.asistentes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fggc.asistentecrud.core.Constants.Companion.ADD
import com.fggc.asistentecrud.core.Constants.Companion.ADD_ASISTENTE
import com.fggc.asistentecrud.core.Constants.Companion.CORREO
import com.fggc.asistentecrud.core.Constants.Companion.DISMISS
import com.fggc.asistentecrud.core.Constants.Companion.FECHA_REGISTRO
import com.fggc.asistentecrud.core.Constants.Companion.MONTO_PAGADO
import com.fggc.asistentecrud.core.Constants.Companion.NOMBRE_COMPLETO
import com.fggc.asistentecrud.core.Constants.Companion.NO_VALUE
import com.fggc.asistentecrud.core.Constants.Companion.TELEFONO
import com.fggc.asistentecrud.core.Constants.Companion.TIPO_SANGRE
import com.fggc.asistentecrud.domain.model.Asistente
import kotlinx.coroutines.job

@Composable
fun AddAsistenteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addAsistente: (asistente: Asistente) -> Unit
){
    if (openDialog){

        var nombreCompleto by remember { mutableStateOf(NO_VALUE) }
        var fechaRegistro by remember { mutableStateOf(NO_VALUE) }
        var tipoSangre by remember { mutableStateOf(NO_VALUE) }
        var telefono by remember { mutableStateOf(NO_VALUE) }
        var correo by remember { mutableStateOf(NO_VALUE) }
        var montoPagado by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_ASISTENTE)
            },
            text = {
                Column() {
                    OutlinedTextField(
                        value = nombreCompleto,
                        onValueChange = {nombreCompleto = it},
                        label = {
                            Text(NOMBRE_COMPLETO)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = fechaRegistro,
                        onValueChange = {fechaRegistro = it},
                        label = {
                            Text(FECHA_REGISTRO)
                        },
                        placeholder = {
                            Text("dd/mm/aaaa")
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = tipoSangre,
                        onValueChange = {tipoSangre = it},
                        label = {
                            Text(TIPO_SANGRE)
                        },
                        placeholder = {
                            Text("A/B/AB/O")
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = telefono,
                        onValueChange = {telefono = it},
                        label = {
                            Text(TELEFONO)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = correo,
                        onValueChange = {correo = it},
                        label = {
                            Text(CORREO)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = montoPagado,
                        onValueChange = {montoPagado = it},
                        label = {
                            Text(MONTO_PAGADO)
                        },
                        placeholder = {
                            Text("00.00")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val asistente = Asistente(
                            0,
                            nombreCompleto,
                            fechaRegistro,
                            tipoSangre,
                            telefono,
                            correo,
                            montoPagado.toDouble())
                        addAsistente(asistente)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog) {
                    Text(DISMISS)
                }
            }
        )
    }
}