package com.fggc.asistentecrud.data.repository

import com.fggc.asistentecrud.data.network.AsistenteDao
import com.fggc.asistentecrud.domain.model.Asistente
import com.fggc.asistentecrud.domain.repository.AsistenteRepository

class AsistenteRepositoryImpl (
    private  val asistenteDao: AsistenteDao
        ): AsistenteRepository{
        override fun getAsistentesFromRoom() = asistenteDao.getAsistentes()
        override fun addAsistenteToRoom(asistente: Asistente) = asistenteDao.addAsistente(asistente)

    // getMascota
    override fun getAsistenteFromRoom(id: Int) = asistenteDao.getAsistente(id)

    // updateMascotas
    override fun updateAsistenteInRoom(asistente: Asistente) =
        asistenteDao.updateAsistente(asistente)

    // deleteMascota
    override fun deleteAsistenteFromRoom(asistente: Asistente) =
        asistenteDao.deleteAsistente(asistente)


        }
