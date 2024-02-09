package com.example.appharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appharia.ui.theme.AppHariaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppHariaTheme{
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "inicio") {
                composable("inicio") {
                    Inicio(
                        onNavigateToFPBasica = { navController.navigate("pantallaFPbasica") },
                        onNavigateToPantallaFPSuperior = { navController.navigate("pantallaFPSuperior") },
                        onNavigateToPantallaFPMedio = { navController.navigate("pantallaFPMedio") }
                    )
                }
                composable("pantallaFPbasica") {
                    PantallaFPbasica(
                        onNavigateToInicio = { navController.navigate("inicio") },
                        onNavigateToFPMedio = { navController.navigate("pantallaFPMedio") },
                        onNavigateToFPSuperior = { navController.navigate("pantallaFPSuperior") }
                    )
                }
                composable("pantallaFPMedio") {
                    PantallaFPmedio(
                        onNavigateToInicio = { navController.navigate("inicio") },
                        onNavigateToFPbasica = { navController.navigate("pantallaFPbasica") },
                        onNavigateToFPSuperior = { navController.navigate("pantallaFPSuperior") }
                    )
                }
                composable("pantallaFPSuperior") {
                    PantallaFPsuperior(
                        onNavigateToInicio = { navController.navigate("inicio") },
                        onNavigateToFPMedio = { navController.navigate("pantallaFPMedio") },
                        onNavigateToFPbasica = { navController.navigate("pantallaFPbasica") }
                    )
                }
            }
        }
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------PANTALLA DE INICIO--------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(onNavigateToFPBasica: () -> Unit,
           onNavigateToPantallaFPSuperior: () -> Unit,
           onNavigateToPantallaFPMedio: () -> Unit) {
    var VerMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                title = {
                    Text(
                        "Inicio",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {} ,
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
                            onClick = onNavigateToFPBasica
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Fp Medio") },
                            onClick = onNavigateToPantallaFPMedio
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Fp Superior") },
                            onClick = onNavigateToPantallaFPSuperior
                        )

                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    Modifier
                        .background(Color.White)
                        .width(400.dp)
                        .height(5.dp)
                ){

                }
                Row(
                    Modifier
                        .background(MaterialTheme.colorScheme.tertiary)
                        .fillMaxWidth()
                        .height(200.dp)

                ){
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.paddingFromBaseline(
                            top = 40.dp,

                            )){
                            IconButton(onClick = onNavigateToFPBasica ,
                                modifier = Modifier.size(75.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpb),
                                    contentDescription = "Logo basico",
                                    modifier = Modifier.fillMaxSize())
                            }
                        }
                        Row(modifier = Modifier.weight(1F)){
                            Text(text = "Grado\nBásico")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.paddingFromBaseline(
                            top = 40.dp
                        )){
                            IconButton(onClick = onNavigateToPantallaFPMedio,
                                modifier = Modifier.size(75.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpm),
                                    contentDescription = "Logo medio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)){
                            Text(text = "Grado\nMedio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.paddingFromBaseline(
                            top = 40.dp
                        )){
                            IconButton(onClick = onNavigateToPantallaFPSuperior ,
                                modifier = Modifier.size(75.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.fps),
                                    contentDescription = "Logo superior",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)){
                            Text(text = "Grado\nSuperior")
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Row {
                        Text(text = "PROYECTOS")
                    }
                    Row {
                        ScrollInicio()
                    }
                }
            }
        }
    )
}

@Composable
fun ScrollInicio( modifier: Modifier = Modifier,
                  names: List<String> = List(6) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            ContenidoInicio(name = name, filled)
        }
    }
}

@Composable
private fun ContenidoInicio(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }

    if ( name == "0") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Cableado estructurado\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Hemos diseñado y ordenado los cables de un aula de informática y colocado unas canaletas en unas mesas para ordenar los cables.")
                    }
                }
            }


        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Diseño de página web\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El Lenguaje de Marcado de Hipertexto (HTML) es el código que se utiliza para estructurar y desplegar una página web y sus contenidos. Por ejemplo, sus contenidos podrían ser párrafos, una lista con viñetas, o imágenes y tablas de datos.")
                    }
                }
            }
        } }
    else if (name == "2") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Elaboración de juegos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Empezaremos a aprender a programar juegos sencillos como el juego de la serpiente, 2048, etc.")
                    }
                }
            }
        }
    } else if (name == "3") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Montaje de equipo\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Vamos a aprender a montar y desmontar equipos y saber cada parte de él, así como disco duro, memoria RAM, etc.")
                    }
                }
            }
        }
    } else if (name == "4") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Diseño de red\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Hemos creado y manipulado ordenadores, routers, switch, etc.")
                    }
                }
            }
        }
    } else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Formación en centros de trabajo\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Vamos a estar 2 meses y medio trabajando en empresas para obtener experiencia laboral.")
                    }
                }
            }
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//--------------------------------------PANTALLA DE FPBASICA-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaFPbasica(
    onNavigateToInicio: () -> Unit,
    onNavigateToFPMedio: () -> Unit,
    onNavigateToFPSuperior: () -> Unit
) {
    var VerMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            // Ajusta el padding para aumentar la altura del TopAppBar
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "FP Básico",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    // Ajusta el tamaño del logo y su margen utilizando el modificador Modifier
                    IconButton(
                        onClick = onNavigateToInicio,
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
                            text = { Text(text = "Inicio") },
                            onClick = onNavigateToInicio)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Medio") },
                            onClick = onNavigateToFPMedio)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Superior") },
                            onClick = onNavigateToFPSuperior)
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    Modifier
                        .background(Color.White)
                        .width(400.dp)
                        .height(5.dp)
                ) {

                }
                Row(
                    Modifier
                        .background(MaterialTheme.colorScheme.tertiary)
                        .fillMaxWidth()
                        .height(200.dp)

                ) {
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp,

                                )
                        ) {
                            IconButton(
                                onClick = onNavigateToInicio,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.inicio),
                                    contentDescription = "Logo inicio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Inicio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPMedio,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpm),
                                    contentDescription = "Logo medio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nMedio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPSuperior,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fps),
                                    contentDescription = "Logo superior",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nSuperior")
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    ScrollBasico()
                }
            }
        }
    )
}

@Composable
fun ScrollBasico( modifier: Modifier = Modifier,
    //names: List<String> = listOf("World", "Compose", "Kaka", "Illojuan", "YowiVT")
                  names: List<String> = List(12) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            //filled = !filled
            ContenidoBasico(name = name, filled)
        }
    }
}

@Composable
private fun ContenidoBasico(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }

    if ( name == "0") {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Primer año")
            }
        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Ciencias Aplicadas I\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El Lenguaje de Marcado de Hipertexto (HTML) es el código que se utiliza para estructurar y desplegar una página web y sus contenidos. Por ejemplo, sus contenidos podrían ser párrafos, una lista con viñetas, o imágenes y tablas de datos.")
                    }
                }
            }
        } }
    else if (name == "2") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Comunicación y Sociedad I\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Empezaremos a aprender a programar juegos sencillos como el juego de la serpiente, 2048, etc.")
                    }
                }
            }
        }
    } else if (name == "3") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Equipos Eléctricos y Electrónicos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Vamos a aprender a montar y desmontar equipos y saber cada parte de él, así como disco duro, memoria RAM, etc.")
                    }
                }
            }
        }
    } else if (name == "4") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Instalación y mantenimiento de redes para transmisión de datos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Hemos creado y manipulado ordenadores, routers, switch, etc.")
                    }
                }
            }
        }
    }else if(name == "5"){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Segundo año")
            }
        }
    }else if(name == "6"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Montaje y mantenimiento de sistemas y componentes informáticos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Se basa en el montaje y mantenimiento de sistemas y componentes informáticos.")
                    }
                }
            }
        }
    }
    else if(name == "7"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Operaciones auxiliares para la configuración y la explotación\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Se realizan operaciones de ensamblado, operaciones de conexionado y operaciones auxiliares en el montaje y mantenimiento de equipos eléctricos y electrónicos.")
                    }
                }
            }
        }
    }
    else if(name == "8"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Formación en centros de trabajo", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Módulo donde los alumnos finalizan sus estudios en las empresas.")
                    }
                }
            }
        }
    }
    else if(name == "9"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Comunicación y sociedad II", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Se desarrolla las habilidades y destrezas lingüísticas, además de alcanzar el nivel de precisión, claridad y fluidez requeridas, para comunicarse en su entorno.")
                    }
                }
            }
        }
    }
    else if(name == "10"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Ciencias aplicadas II", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Aplicación del conocimiento científico básico a necesidades humanas y al desarrollo tecnológico.")
                    }
                }
            }
        }
    }
    else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Requisitos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Tener cumplidos quince años, o cumplirlos durante el año natural en curso, y no superar los diecisiete años de edad en el momento del acceso o durante el año natural en curso.\n\n" +
                                    "Haber cursado el primer ciclo de Educación Secundaria Obligatoria (3º de la ESO) o, excepcionalmente, haber cursado el segundo curso de la Educación Secundaria Obligatoria.\n\n" +
                                    "Haber propuesto el equipo docente a los padres, madres o tutores legales la incorporación del alumno o alumna a un ciclo de Formación Profesional Básica")

                    }
                }
            }
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//--------------------------------------PANTALLA DE FP-MEDIO-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaFPmedio(
    onNavigateToInicio: () -> Unit,
    onNavigateToFPbasica: () -> Unit,
    onNavigateToFPSuperior: () -> Unit
) {
    var VerMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "FP Medio",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateToInicio,
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
                            contentDescription = "menú"
                        )
                    }
                    DropdownMenu(
                        expanded = VerMenu,
                        onDismissRequest = { VerMenu = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Inicio") },
                            onClick = onNavigateToInicio)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Básico") },
                            onClick = onNavigateToFPbasica)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Superior") },
                            onClick = onNavigateToFPSuperior)
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    Modifier
                        .background(Color.White)
                        .width(400.dp)
                        .height(5.dp)
                ) {

                }
                Row(
                    Modifier
                        .background(MaterialTheme.colorScheme.tertiary)
                        .fillMaxWidth()
                        .height(200.dp)

                ){
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp,

                                )
                        ) {
                            IconButton(
                                onClick = onNavigateToInicio,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.inicio),
                                    contentDescription = "Logo inicio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Inicio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPbasica,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpb),
                                    contentDescription = "Logo Básico",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nBásico")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPSuperior,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fps),
                                    contentDescription = "Logo superior",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nSuperior")
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Scrollmedio()
                }
            }
        }
    )
}

@Composable
fun Scrollmedio( modifier: Modifier = Modifier,
                 names: List<String> = List(15) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            //filled = !filled
            ContenidoMedio(name = name, filled)
        }
    }
}

@Composable
private fun ContenidoMedio(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }

    if (name == "0") {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Primer año")
            }
        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Redes Locales", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(
                        modifier = Modifier.paddingFromBaseline(
                            top = 30.dp
                        )
                    ) {
                        Text(text = "Esta asignatura trata sobre la tecnología que existe para conectar diferentes equipos a través de una red local. Te adentrarás en el funcionamiento de todas ellas y sabrás cuáles son las más utilizadas en las empresas por el momento y qué tecnologías de red local se usarán en un futuro próximo.")
                    }
                }
            }
        }
    } else if (name == "2") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Sistemas Operativos Monopuestos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(
                        modifier = Modifier.paddingFromBaseline(
                            top = 30.dp
                        )
                    ) {
                        Text(text = "Como el nombre indica, el módulo trata sobre los sistemas operativos y su configuración, todo esto se realizará creando máquinas virtuales.")
                    }
                }
            }
        }
    } else if (name == "3") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Aplicaciones Ofimáticas", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(
                        modifier = Modifier.paddingFromBaseline(
                            top = 30.dp
                        )
                    ) {
                        Text(text = "En este módulo aprenderás a manejar a nivel de experto todas las aplicaciones ofimáticas: Word, Excel, Power Point y Acces. ¡No habrá ninguna que se te resista! Se trata de herramientas esenciales que exigen en prácticamente cualquier trabajo de oficina en la actualidad y además son la base para interiorizar con facilidad todo lo que vendrá después.")
                    }
                }
            }
        }
    } else if (name == "4") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(
                        text = "Montaje y mantenimiento de equipos",
                        modifier = Modifier.weight(1f)
                    )
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(
                        modifier = Modifier.paddingFromBaseline(
                            top = 30.dp
                        )
                    ) {
                        Text(text = "Gracias a este módulo conocerás cada pieza que forman los equipos microinformáticos de hoy en día. Su montaje y mantenimiento serán pan comido para ti cuando estudies la asignatura y cojas un poco de práctica.")
                    }
                }
            }
        }
    } else if (name == "5") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(
                        text = "Formación y Orientación Laboral",
                        modifier = Modifier.weight(1f)
                    )
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(
                        modifier = Modifier.paddingFromBaseline(
                            top = 30.dp
                        )
                    ) {
                        Text(text = "Gracias a este módulo conocerás cada pieza que forman los equipos microinformáticos de hoy en día. Su montaje y mantenimiento serán pan comido para ti cuando estudies la asignatura y cojas un poco de práctica.")
                    }
                }
            }
        }
    }

else if(name == "6"){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Segundo año")
            }
        }
    }else if(name == "7"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Servicios en Red", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Gracias a esta asignatura conocerás el funcionamiento de los sistemas en red. Los conceptos que verás en ella están relacionados con la arquitectura creada en torno a un equipo y un servidor.")
                    }
                }
            }
        }
    }
    else if(name == "8"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Seguridad Informática", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "En un mundo en el que los ataques informáticos están a la orden del día, no puede faltar este módulo en la FP de un profesional informático. Aquí aprenderás a proteger los equipos frente a los ciberataques y a reparar posibles daños como consecuencia de los mismos.")
                    }
                }
            }
        }
    }
    else if(name == "9"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Sistemas Operativos en Red", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Este módulo te adentra en el mundo de los sistemas operativos de una manera más amplia, conociendo cómo funcionan en red, de tal manera que dos o más usuarios pueden intervenir.")
                    }
                }
            }
        }
    }
    else if(name == "10"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Empresas e Iniciativa Empresarial", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Si tienes espíritu emprendedor y quieres montar tu propio negocio en el sector informático, esta asignatura te encantará, ya que te facilita toda la información que necesitas para trabajar por tu cuenta, desde el alta de la empresa hasta el lanzamiento del servicio, pasando por las diferentes formas de financiación que puedes conseguir.")
                    }
                }
            }
        }
    }
    else if(name == "11"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Aplicaciones Web", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "En esta asignatura aprenderás lo que un profesional informático debe saber sobre aplicaciones web, uno de los recursos más interesantes que utilizan los desarrolladores para satisfacer las necesidades de cualquier propietario en relación a su página web.")
                    }
                }
            }
        }
    }
    else if(name == "12"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {
                    Text(text = "Formación en Centro de Trabajos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El último trimestre se realizan prácticas en empresas que busca el centro para tu formación en las que tendrán un tutor quien les enseñará. Esto es algo grandioso ya que obtienes experiencia laboral.")
                    }
                }
            }
        }
    }
    else if(name == "13"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {
                    Text(text = "Integración", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "La integración es el proceso y resultado de mantener unidas las partes de un todo. Puede ser aplicable en diversos ámbitos, como el social, político y económico. Es decir, la integración es juntar diversos elementos que forman parte de un conjunto en común.")
                    }
                }
            }
        }
    }
    else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Requisitos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Título de graduado/a: En Educación Secundaria Obligatoria, Formación Profesional de Grado Básico o Título de Técnico/a o de Técnico/a Auxiliar o equivalente a efectos académicos.\n\n " +
                                    "Haber superado: Prueba de acceso a ciclos formativos de grado medio (se requerirá tener, al menos, diecisiete años, cumplidos en el año de realización de la prueba).\n\n" +
                                    "Prueba de acceso a la Universidad para mayores de 25 años (la superación de las pruebas de acceso a la Universidad para mayores de 40 y 45 años no es un requisito válido para acceder a FP).\n\n" +
                                    "¿Qué se aprenderá?: Experto en instalar y configurar software, redes locales y dispositivos. Gestiona servicios y aplicaciones, realiza montaje de equipos, optimiza la logística y redes locales. Especialista en recuperación de datos, documentación técnica y asesoramiento al cliente. ")
                    }
                }
            }
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//--------------------------------------PANTALLA DE FP-SUPERIOR-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaFPsuperior(
    onNavigateToInicio: () -> Unit,
    onNavigateToFPbasica: () -> Unit,
    onNavigateToFPMedio: () -> Unit
) {
    var VerMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "FP Superior",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {

                    IconButton(
                        onClick = onNavigateToInicio,
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
                            contentDescription = "menú"
                        )
                    }
                    DropdownMenu(
                        expanded = VerMenu,
                        onDismissRequest = { VerMenu = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Inicio") },
                            onClick = onNavigateToInicio)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Basica") },
                            onClick = onNavigateToFPbasica)
                        DropdownMenuItem(
                            text = { Text(text = "Fp Medio") },
                            onClick = onNavigateToFPMedio)
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    Modifier
                        .background(Color.White)
                        .width(400.dp)
                        .height(5.dp)
                ) {

                }
                Row(
                    Modifier
                        .background(MaterialTheme.colorScheme.tertiary)
                        .fillMaxWidth()
                        .height(200.dp)

                ) {
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp,

                                )
                        ) {
                            IconButton(
                                onClick = onNavigateToInicio,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.inicio),
                                    contentDescription = "Logo inicio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Inicio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPMedio,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpm),
                                    contentDescription = "Logo medio",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nMedio")
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.paddingFromBaseline(
                                top = 40.dp
                            )
                        ) {
                            IconButton(
                                onClick = onNavigateToFPbasica,
                                modifier = Modifier.size(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fpb),
                                    contentDescription = "Logo Básica",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Row(modifier = Modifier.weight(1F)) {
                            Text(text = "Grado\nBásica")
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    ScrollSuperior()
                }
            }
        }
    )
}

@Composable
fun ScrollSuperior( modifier: Modifier = Modifier,
            names: List<String> = List(18) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            //filled = !filled
            Contenidosuperior(name = name, filled)
        }
    }
}

@Composable
private fun Contenidosuperior(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }

    if ( name == "0") {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Primer año")
            }
        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Sistemas informáticos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El objetivo del módulo de \"Sistemas Informáticos\" pretende formar al alumno en los distintos sistemas informáticos, principalmente en lo que respecta a los sistemas operativos, las aplicaciones de propósito general y las redes de área local.")
                    }
                }
            }
        } }
    else if (name == "2") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Base de datos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Este módulo profesional contiene la formación necesaria para desempeñar funciones relacionadas con la gestión de la información almacenada en bases de datos y el desarrollo de aplicaciones que acceden a bases de datos.")
                    }
                }
            }
        }
    } else if (name == "3") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Programación", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Este módulo profesional contiene parte de la formación necesaria para desempeñar la función de programación de aplicaciones de propósito general en lenguajes orientados a objetos.")
                    }
                }
            }
        }
    } else if (name == "4") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Lenguajes de marcas", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Este módulo profesional contiene la formación necesaria para desempeñar la funciónde gestión y explotación de sistemas de información.")
                    }
                }
            }
        }
    }
        else if (name == "5") {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                        .fillMaxSize()
                ) {
                    Row {

                        Text(text = "Entorno de Desarrollo", modifier = Modifier.weight(1f))
                        ElevatedButton(
                            onClick = { estado.value = !estado.value }
                        ) {
                            Text(if (estado.value) "▲" else "▼")
                        }
                    }
                    if (estado.value == true) {
                        Row(modifier = Modifier.paddingFromBaseline(
                            top = 30.dp)){
                            Text(text = "Este módulo profesional contiene la formación necesaria para la utilización de las herramientas software disponibles, la elaboración de documentación interna y técnica de la aplicación, elaboración y ejecución de pruebas y la optimización de código.")
                        }
                    }
                }
            }
    }
            else if (name == "6") {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .animateContentSize(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            )
                            .fillMaxSize()
                    ) {
                        Row {

                            Text(text = "Formación y orientación laboral", modifier = Modifier.weight(1f))
                            ElevatedButton(
                                onClick = { estado.value = !estado.value }
                            ) {
                                Text(if (estado.value) "▲" else "▼")
                            }
                        }
                        if (estado.value == true) {
                            Row(modifier = Modifier.paddingFromBaseline(
                                top = 30.dp)){
                                Text(text = "Este módulo profesional contiene la formación necesaria para que el alumno pueda insertarse laboralmente y desarrollar su carrera profesional en el sector del Desarrollo de Aplicaciones multiplataforma.")
                            }
                        }
                    }
                }
    }
                else if (name == "7") {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .animateContentSize(
                                    animationSpec = spring(
                                        dampingRatio = Spring.DampingRatioMediumBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                                )
                                .fillMaxSize()
                        ) {
                            Row {

                                Text(text = "Inglés", modifier = Modifier.weight(1f))
                                ElevatedButton(
                                    onClick = { estado.value = !estado.value }
                                ) {
                                    Text(if (estado.value) "▲" else "▼")
                                }
                            }
                            if (estado.value == true) {
                                Row(modifier = Modifier.paddingFromBaseline(
                                    top = 30.dp)){
                                    Text(text = "La asignatura de inglés se enfoca principalmente al sector informático, enseñandote nuevo vocabulario relacionado con el mundo informático")
                                }
                            }
                        }
                    }
    }else if(name == "8"){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                Text(text = "Segundo año")
            }
        }
    }else if(name == "9"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Acceso de datos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El objetivo de la asignatura de Acceso a Datos es proporcionar a los estudiantes los conocimientos y habilidades necesarios para diseñar, implementar y gestionar sistemas de bases de datos de manera efectiva y segura.")
                    }
                }
            }
        }
    }
    else if(name == "10"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Desarrollo de interfaces", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El objetivo de la asignatura de Desarrollo de Interfaces en el ciclo superior de DAM es proporcionar a los estudiantes los conocimientos y habilidades necesarios para diseñar y desarrollar interfaces de usuario para aplicaciones informáticas.")
                    }
                }
            }
        }
    }
    else if(name == "11"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Programación multimedia y dispositivos móviles", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El objetivo de la asignatura de Programación multimedia y dispositivos móviles en el ciclo superior de DAM es proporcionar a los estudiantes los conocimientos y habilidades necesarios para desarrollar aplicaciones multimedia y para dispositivos móviles.")
                    }
                }
            }
        }
    }
    else if(name == "12"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Programación de servicios y procesos", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El objetivo de la asignatura de Programación de servicios y procesos en el ciclo superior de DAM es proporcionar a los estudiantes los conocimientos y habilidades necesarios para diseñar, implementar y desplegar servicios y procesos en sistemas informáticos.")
                    }
                }
            }
        }
    }
    else if(name == "13"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Sistemas de gestión empresarial", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "La asignatura de Sistemas de gestión empresarial en el ciclo superior de DAM tiene como objetivo proporcionar a los estudiantes los conocimientos necesarios para comprender el funcionamiento de los sistemas de gestión empresarial y aprender a utilizar herramientas para su implementación.")
                    }
                }
            }
        }
    }
    else if(name == "14"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Desarrollo de aplicaciones multiplataforma", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "La asignatura de Proyecto de desarrollo de aplicaciones multiplataforma en el ciclo superior de DAM tiene como objetivo proporcionar a los estudiantes la oportunidad de aplicar los conocimientos y habilidades adquiridos en las diferentes asignaturas del ciclo formativo en un proyecto de desarrollo de software real, con el fin de que los estudiantes puedan desarrollar habilidades en la gestión y dirección de proyectos de software.")
                    }
                }
            }
        }
    }
    else if(name == "15"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Formación en centros de trabajo", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "En el caso del ciclo de DAM, durante la FCT, los estudiantes pueden trabajar en empresas relacionadas con el desarrollo de software y aplicaciones para diferentes plataformas, como Android, iOS o Windows. Los estudiantes pueden participar en proyectos de desarrollo de software, pruebas de calidad, mantenimiento de sistemas, entre otras actividades relacionadas con el desarrollo de aplicaciones multiplataforma.")
                    }
                }
            }
        }
    }
    else if(name == "16"){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Empresa e iniciativa emprendedora", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "En el caso del ciclo de DAM, durante la FCT, los estudiantes pueden trabajar en empresas relacionadas con el desarrollo de software y aplicaciones para diferentes plataformas, como Android, iOS o Windows. Los estudiantes pueden participar en proyectos de desarrollo de software, pruebas de calidad, mantenimiento de sistemas, entre otras actividades relacionadas con el desarrollo de aplicaciones multiplataforma.")
                    }
                }
            }
        }
    }
    else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Requisitos\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }
                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Único requisito para entrar en un ciclo superior de Desarrollo de Aplicaciones Multiplataforma (DAM) es necesario haber obtenido el título de Bachillerato o un título de Grado Medio.\n\n" +
                                    "Objetivo del ciclo: El ciclo superior de DAM está diseñado para proporcionar a los estudiantes una formación completa en el desarrollo de aplicaciones multiplataforma, incluyendo la programación de aplicaciones, la creación de interfaces gráficas de usuario, el diseño de bases de datos, la gestión de proyectos, el desarrollo de aplicaciones móviles, la seguridad informática y otros temas relacionados.")
                    }
                }
            }
        }
    }
}

