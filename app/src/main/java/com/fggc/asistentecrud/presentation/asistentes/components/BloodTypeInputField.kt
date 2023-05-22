package com.fggc.asistentecrud.presentation.asistentes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.asistentecrud.core.Constants.Companion.TIPO_SANGRE

@Composable
fun BloodTypeInputField(
    tipoSangre: String,
    onBloodTypeSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val availableBloodTypes = listOf("A", "B", "AB", "O")
    val selectedIndex = availableBloodTypes.indexOf(tipoSangre)

    OutlinedTextField(
        value = tipoSangre,
        onValueChange = {},
        label = {
            Text(TIPO_SANGRE)
        },
        readOnly = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand"
            )
        },
        modifier = Modifier.clickable { expanded = true }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        availableBloodTypes.forEachIndexed { index, bloodType ->
            DropdownMenuItem(
                onClick = {
                    onBloodTypeSelected(bloodType)
                    expanded = false
                },
                modifier = Modifier.width(IntrinsicSize.Min)
            ) {
                Text(
                    text = bloodType,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}
