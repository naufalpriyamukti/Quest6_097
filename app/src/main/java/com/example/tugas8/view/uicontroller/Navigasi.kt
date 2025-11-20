package com.example.tugas8.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas8.model.DataJK.JenisJK
import com.example.tugas8.view.FormSiswa
import com.example.tugas8.view.TampilSiswa
import com.example.tugas8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: SiswaViewModel = viewModel()
) {
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Navigasi.Formulirku.name,
        modifier = modifier
    ) {
        composable(route = Navigasi.Formulirku.name) {
            val konteks = LocalContext.current
            FormSiswa(
                pilihanJK = JenisJK.map { id -> konteks.getString(id) },
                onSubmitButtonClicked = {
                    viewModel.setSiswa(it)
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name) {
            TampilSiswa(
                statusUiSiswa = uiState,
                onBackButtonClicked = {
                    cancelAndBackToFormulirku(navController)
                }
            )
        }
    }
}

private fun cancelAndBackToFormulirku(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulirku.name, inclusive = false)
}
