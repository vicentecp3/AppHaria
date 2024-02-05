package com.example.appharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.appharia.ui.theme.AppHariaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppHariaTheme {
              Myapp()

            }
        }
    }
}

@Composable
fun Myapp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        var shouldShowOnboarding by remember { mutableStateOf(true) }
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            if (shouldShowOnboarding) {
                Incio(onContinueClicked = { shouldShowOnboarding = false })
            } else if(!shouldShowOnboarding){
                PantallaFPbasica(onContinueClicked = { shouldShowOnboarding = true })
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Incio(onContinueClicked: () -> Unit) {
    var VerMenu by remember { mutableStateOf(false) }
    Column {
        Scaffold(
            topBar = {
                // Ajusta el padding para aumentar la altura del TopAppBar
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            "Inicio",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        // Ajusta el tamaño del logo y su margen utilizando el modificador Modifier
                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(90.dp)
                                .padding(8.dp) // Puedes ajustar los valores según tus necesidades
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_ies_haria),
                                contentDescription = "Logo iesHaría",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { VerMenu = !VerMenu }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "menú"
                            )
                        }
                        DropdownMenu(
                            expanded = VerMenu,
                            onDismissRequest = { VerMenu = false }) {
                            DropdownMenuItem(
                                text = { Text(text = "Fp basico") },
                                onClick = { onContinueClicked() })
                            DropdownMenuItem(
                                text = { Text(text = "Fp Medio") },
                                onClick = { onContinueClicked() })
                            DropdownMenuItem(
                                text = { Text(text = "Fp Superior") },
                                onClick = { onContinueClicked() })
                        }
                    }
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                }
            }
        )
        Card(Modifier.background(Color.Green)){
            Text(text = "fdf")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaFPbasica(onContinueClicked: () -> Unit) {
    var VerMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "fp",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {  },
                        modifier = Modifier
                            .size(90.dp)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_ies_haria),
                            contentDescription = "Logo iesHaría",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                },
                    actions = {
                        IconButton(onClick = { VerMenu = !VerMenu }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "menú")
                        }
                        DropdownMenu(
                            expanded = VerMenu,
                            onDismissRequest = { VerMenu = false }) {
                            DropdownMenuItem(
                                text = { Text(text = "Fp basico")},
                                onClick = { onContinueClicked() })
                            DropdownMenuItem(
                                text = { Text(text = "Fp Medio")},
                                onClick = { onContinueClicked() })
                            DropdownMenuItem(
                                text = { Text(text = "Fp Superior")},
                                onClick = { onContinueClicked() })
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Contenido de la columna
            }
        }
    )
}








