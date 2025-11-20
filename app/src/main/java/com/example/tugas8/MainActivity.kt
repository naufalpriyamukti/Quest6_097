package com.example.tugas8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugas8.ui.theme.Tugas8Theme
import com.example.tugas8.view.uicontroller.SiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas8Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SiswaApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


