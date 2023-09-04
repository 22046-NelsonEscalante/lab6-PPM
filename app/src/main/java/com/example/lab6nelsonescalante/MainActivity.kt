package com.example.lab6nelsonescalante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab6nelsonescalante.ui.theme.Lab6NelsonEscalanteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6NelsonEscalanteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    val user = "Nelson"
    val password = "abcde"
    val context = LocalContext.current
    var field1 by rememberSaveable { mutableStateOf("") }
    var field2 by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center) {

        Text(
            text = "Usuario"
        )

        TextField(
            value = field1,
            onValueChange = {field1 = it}
        )

        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = "Contraseña"
        )

        TextField(
            value = field2,
            onValueChange = {field2 = it}
        )

        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {
                if (field1 == user && field2 == password) {
                    val intent = Intent(context, Gallery::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            },

        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab6NelsonEscalanteTheme {
        Login("Android")
    }
}