package com.fggc.asistentecrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.asistentecrud.core.Constants.Companion.ASISTENTE_ID
import com.fggc.asistentecrud.navigation.Screen.*
import com.fggc.asistentecrud.presentation.asistentes.AsistenteScreen
import com.fggc.asistentecrud.presentation.update_asistentes.UpdateAsistenteScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination =  AsistentesScreen.route ){
        composable(
            route = AsistentesScreen.route
        ){
            AsistenteScreen(
                navigateToUpdateAsistenteScreen = {
                    asistenteId ->
                    navController.navigate(
                        "${UpdateAsistenteScreen.route}/${asistenteId}")
                }
            )
        }
        composable(
            route = "${UpdateAsistenteScreen.route}/{$ASISTENTE_ID}",
            arguments = listOf(
                navArgument(ASISTENTE_ID){
                    type = NavType.IntType
                }
            )
        ){
            backStackEntry ->
            val asistenteId = backStackEntry.arguments?.getInt(ASISTENTE_ID) ?:0
            UpdateAsistenteScreen(
                asistenteId = asistenteId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}