package com.fggc.asistentecrud.domain.repository

import com.fggc.asistentecrud.domain.model.Asistente
import kotlinx.coroutines.flow.Flow

typealias Asistentes = List<Asistente>
interface AsistenteRepository {
    fun getAsistentesFromRoom() : Flow<Asistentes>
    fun addAsistenteToRoom(asistente: Asistente)
    // getAsistenteFromRoom
    fun getAsistenteFromRoom(id: Int): Asistente
    //updateAsistenteInRoom
    fun updateAsistenteInRoom(asistente: Asistente)
    //deleteAsistenteFromRoom
    fun deleteAsistenteFromRoom(asistente: Asistente)


}