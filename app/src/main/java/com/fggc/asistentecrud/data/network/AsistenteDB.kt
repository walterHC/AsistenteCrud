package com.fggc.asistentecrud.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.asistentecrud.domain.model.Asistente

@Database(entities = [Asistente::class], version = 1, exportSchema = false)
abstract  class AsistenteDB: RoomDatabase() {
    abstract fun asistenteDao(): AsistenteDao
}