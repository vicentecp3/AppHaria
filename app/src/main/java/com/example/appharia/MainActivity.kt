package com.example.appharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
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
fun Myapp(/* modifier: Modifier = Modifier,
    //names: List<String> = listOf("World", "Compose", "Kaka", "Illojuan", "YowiVT")
           names: List<String> = List(6) { "$it" }
           */) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        var shouldShowOnboarding by remember { mutableStateOf(true) }
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            if (shouldShowOnboarding) {
                Inicio(onContinueClicked = { shouldShowOnboarding = false })
            } else if(!shouldShowOnboarding){
                PantallaFPbasica(onContinueClicked = { shouldShowOnboarding = true })
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(onContinueClicked: () -> Unit) {
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
                            .width(400.dp)
                            .height(200.dp)

                    ){
                        Column(
                            modifier = Modifier.weight(1F),
                            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(modifier = Modifier.paddingFromBaseline(
                                top = 40.dp,

                            )){
                                IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                                IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                                IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                            Greetings()
                        }
                    }
                }
            }
        )
}

@Composable
fun Greetings( modifier: Modifier = Modifier,
    //names: List<String> = listOf("World", "Compose", "Kaka", "Illojuan", "YowiVT")
               names: List<String> = List(6) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            //filled = !filled
            Contenido1(name = name, filled)
        }
    }
}

@Composable
private fun Contenido1(name: String, filled: Boolean) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaFPbasica(onContinueClicked: () -> Unit) {
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
                            text = { Text(text = "Inicio") },
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
                        .width(400.dp)
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
                                onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                                onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                                onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                    Greetings()
                }
            }
        }
    )
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun app(){
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
                        .width(400.dp)
                        .height(200.dp)

                ){
                    Column(
                        modifier = Modifier.weight(1F),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.paddingFromBaseline(
                            top = 40.dp,

                            )){
                            IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                            IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                            IconButton(onClick = { /*LINKKKKKKKKKKKKKKKKKKKKKKKKKS*/ },
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
                        Greetings()
                    }
                }
            }
        }
    )
}

@Composable
fun Greetings2(){

}








