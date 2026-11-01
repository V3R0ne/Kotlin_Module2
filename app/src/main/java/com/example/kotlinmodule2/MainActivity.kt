package com.example.kotlinmodule2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.kotlinmodule2.task10.ShoppingCartScreen
import com.example.kotlinmodule2.ui.theme.KotlinModule2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinModule2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShoppingCartScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
