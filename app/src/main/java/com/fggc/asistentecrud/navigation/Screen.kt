package com.fggc.asistentecrud.navigation

import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTES_SCREEN
import com.fggc.asistentecrud.core.Constants.Companion.UPDATE_ASISTENTE_SCREEN

sealed class Screen(val route: String){
    object AsistentesScreen: Screen(ASISTENTES_SCREEN)
    object UpdateAsistenteScreen: Screen(UPDATE_ASISTENTE_SCREEN)
}
