package com.fggc.asistentecrud.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTE_TABLE

@Entity (tableName = ASISTENTE_TABLE)
data class Asistente(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val nombre_completo: String,
    val fecha_registro: String,
    val tipo_sangre: String,
    val telefono: String,
    val correo: String,
    val monto_pagado: Double
)
