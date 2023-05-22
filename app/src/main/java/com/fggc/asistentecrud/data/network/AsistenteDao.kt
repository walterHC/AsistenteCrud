package com.fggc.asistentecrud.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTE_TABLE
import com.fggc.asistentecrud.domain.model.Asistente
import com.fggc.asistentecrud.domain.repository.Asistentes
import kotlinx.coroutines.flow.Flow

@Dao
interface AsistenteDao {
    @Query("SELECT * FROM $ASISTENTE_TABLE ORDER BY id ASC")
    fun getAsistentes(): Flow<Asistentes>

    @Insert(onConflict = IGNORE)
    fun addAsistente(asistente: Asistente)

    // getAsistente
    @Query("SELECT * FROM $ASISTENTE_TABLE WHERE id = :id")
    fun getAsistente(id: Int): Asistente

    // updateAsistente
    @Update
    fun updateAsistente(asistente: Asistente)

    // deleteAsistente
    @Delete
    fun deleteAsistente(asistente: Asistente)

}