package br.edu.ifto.dposite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.edu.ifto.dposite.R

@Composable
fun Reproduzirimagem(navController: NavController){


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF000000), // 0%: Azul mais escuro
                        Color(0xFF000000), // 50%: Azul intermediário
                        Color(0xFF000000)  // 75%: Azul claro
                    ),
                    start = Offset(0f, 0f),   // Começa no topo esquerdo
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Vai até o fundo
                )
            )
    ){
        Row (modifier = Modifier.fillMaxWidth().offset(0.dp, 30.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(R.drawable.favorit),
                contentDescription = "Girar", modifier = Modifier.size(40.dp).padding(end = 10.dp).size(50.dp))
            Image(painter = painterResource(R.drawable.baixar),
                contentDescription = "Baixar", modifier = Modifier.size(40.dp))
        }
        Image(
            painter = painterResource(R.drawable.videoreproduzir),
            contentDescription = "Imagem reproduzir",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .clickable { navController.navigate("Carregamentos") },
            contentScale = ContentScale.Fit
        )
    }
}