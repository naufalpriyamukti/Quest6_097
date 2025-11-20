package com.example.tugas8.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class SiswaViewModel : ViewModel() {
    private val_statusUI = MutableStateFlow(value = Siswa())

    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(ls:MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[2]
            )
        }
    }

}