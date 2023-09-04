package com.example.lab6nelsonescalante

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab6nelsonescalante.ui.theme.Lab6NelsonEscalanteTheme

class Gallery : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6NelsonEscalanteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Gall(0)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Gall(index: Int) {
    val context = LocalContext.current
    var index by rememberSaveable { mutableStateOf(0) }
    val caption: List<String> = listOf(
        "Miau",
        "Guau",
        "Gato marinero",
        "Gato azul",
        "Gato con ojos de flores",
        "Gato distorsionado.",
        "Ness",
        "Paula",
        "Jeff",
        "Poo"
    )
    val authors: List<String> = listOf(
        "Un gatito!",
        "Un perrito!",
        "Este gato era parte de la tripulación.",
        "Louis Wain. A él le gustaban los gatos.",
        "Louis Wain. Esta es la obra que más me gusta.",
        "Louis Wain. Mientras su estado mental empeoraba, su percepción se alteraba cada vez más.",
        "Protagonista del videojuego 'Earthbound'.",
        "Amiga de Ness. Capaz de usar poderes psíquicos.",
        "Amigo de Ness. Utiliza sus invenciones en combate.",
        "Amigo de Ness. Utiliza artes marciales para combatir."
    )
    val images: List<Int> = listOf(
        R.drawable.miau,
        R.drawable.perrito,
        R.drawable.gato_marinero,
        R.drawable.bluecat,
        R.drawable.flowereyes,
        R.drawable.distortedcat,
        R.drawable.ness_clay,
        R.drawable.paula_clay,
        R.drawable.jeff_clay,
        R.drawable.poo_clay
    )

    Column() {

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = "Logout",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Right

                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(images[index]),
                contentDescription = "Gatito",
                modifier = Modifier
                    .height(250.dp)
                    .width(100.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = caption[index],
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = authors[index],
                    modifier = Modifier.padding(10.dp)
                )

            }

            Row(horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        if (index == 0) {
                            index = 9
                        } else {
                            index -= 1
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Text(
                        text = "Anterior",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Button(
                    onClick = {
                        if (index == 9) {
                            index = 0
                        } else {
                            index += 1
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Text(
                        text = "Siguiente",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GalleryPreview() {
    Lab6NelsonEscalanteTheme {
        Gall(0)
    }
}