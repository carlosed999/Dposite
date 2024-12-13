package br.edu.ifto.dposite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifto.dposite.ui.theme.DpositeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifto.dposite.ui.theme.Adicionarfotos
import br.edu.ifto.dposite.ui.theme.Adicionarvideos
import br.edu.ifto.dposite.ui.theme.Criaralbum
import br.edu.ifto.dposite.ui.theme.Favoritos

@Composable
fun FigmaGradientScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF596495), // 0%: Azul mais escuro
                        Color(0xFF3D8BC5), // 50%: Azul intermediário
                        Color(0xFF708EBC)  // 75%: Azul claro
                    ),
                    start = Offset(0f, 0f),   // Começa no topo esquerdo
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Vai até o fundo
                )
            )
    ) {
        // Coloque os componentes da sua tela aqui
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DpositeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Inicio") {
                       composable("Inicio"){ Inicio(navController = navController)}
                      composable("Login"){ Login(navController = navController) }
                       composable("Cadastro"){ Cadastro(navController = navController) }
                       composable("Carregamentos"){ Carregamentos(navController = navController) }
                       composable("Perfil"){ Perfil(navController = navController) }
                        composable("Albuns"){ Albuns(navController = navController)}
                        composable("ArmazenamentoFotos"){ ArmazenamentoFotos(navController = navController)}
                        composable("Armazenamentovideo"){ Armazenamentovideo(navController = navController)}
                        composable("Favoritos"){ Favoritos(navController = navController) }
                        composable("Adicionarvideos"){ Adicionarvideos(navController = navController) }
                        composable("Adicionarfotos"){ Adicionarfotos(navController = navController) }
                        composable("Criaralbum"){ Criaralbum(navController = navController) }
                        composable("Reproduzirimagem"){ Reproduzirimagem(navController = navController) }
                        composable("Reproduzirvideo"){ Reproduzirvideo(navController = navController) }


                   }




                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DpositeTheme {
        Greeting("Android")
    }
}