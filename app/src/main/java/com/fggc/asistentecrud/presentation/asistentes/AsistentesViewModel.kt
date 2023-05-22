package com.fggc.asistentecrud.presentation.asistentes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.asistentecrud.core.Constants.Companion.NO_VALUE
import com.fggc.asistentecrud.domain.model.Asistente
import com.fggc.asistentecrud.domain.repository.AsistenteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AsistentesViewModel @Inject constructor(
    private val repo: AsistenteRepository
): ViewModel() {

    var asistente by mutableStateOf(Asistente(0, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE,0.0))
    var openDialog by mutableStateOf(false)
    val asistentes = repo.getAsistentesFromRoom()
    fun addAsistente(asistente: Asistente)= viewModelScope.launch(Dispatchers.IO)
    {
        repo.addAsistenteToRoom(asistente)
    }
    fun closeDialog(){
        openDialog = false
    }
    fun openDialog(){
        openDialog = true
    }
    fun deleteAsistente(asistente: Asistente) =
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteAsistenteFromRoom(asistente)
        }

    fun updateNombreCompleto(nombre: String){
        asistente = asistente.copy(
            nombre_completo = nombre
        )
    }

    fun updateTelefono(telefono: String){
        asistente = asistente.copy(
            telefono = telefono
        )
    }

    fun updateCorreo(correo: String){
        asistente = asistente.copy(
            correo = correo
        )
    }

    fun updateAsistente(asistente: Asistente) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateAsistenteInRoom(asistente)
        }

    fun getAsistente(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        asistente = repo.getAsistenteFromRoom(id)
    }
}