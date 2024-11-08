package com.example.corrutinaspruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinaspruebas.ui.theme.CorrutinasPruebasTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Interfaz
            Surface {
                Interfaz()
            }
        }
    }
}


@Composable
fun Interfaz() {
    val viaje = remember { mutableStateOf("Esperando para subir al cohete...") }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Estado del viaje: ${viaje.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Lanzamos la corutina dentro de un composable y actualizamos el estado de viaje
            coroutineScope.launch {
                viaje.value = hacerViaje()
            }
        }) {
            Text(text = "Iniciar viaje")
        }
    }
}


// Función suspendida que simula un viaje (espera de 5 segundos)
suspend fun hacerViaje(): String {
    delay(5000) // Simula la espera
    return "Felicidades llegaste a la luna"
}