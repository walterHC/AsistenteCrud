package com.fggc.asistentecrud.di

import android.content.Context
import androidx.room.Room
import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTE_TABLE
import com.fggc.asistentecrud.data.network.AsistenteDB
import com.fggc.asistentecrud.data.network.AsistenteDao
import com.fggc.asistentecrud.data.repository.AsistenteRepositoryImpl
import com.fggc.asistentecrud.domain.repository.AsistenteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAsistenteDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
    AsistenteDB::class.java,
        ASISTENTE_TABLE
        ).build()

    @Provides
    fun provideAsistenteDao(
        asistenteDB: AsistenteDB
    ) = asistenteDB.asistenteDao()

    @Provides
    fun provideAsistenteRepository(
        asistenteDao: AsistenteDao
    ): AsistenteRepository = AsistenteRepositoryImpl(
        asistenteDao = asistenteDao
    )

}

