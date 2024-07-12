package com.example.jetpack_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.jetpack_demo.ui.screens.FunFactsNavigationGraph
import com.example.jetpack_demo.ui.theme.Jetpack_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_demoTheme {
                funFactsApp()
            }
        }
    }
}

@Composable
fun funFactsApp() {
    FunFactsNavigationGraph()
}

