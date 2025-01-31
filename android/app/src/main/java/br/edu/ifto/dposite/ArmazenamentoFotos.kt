package br.edu.ifto.dposite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ArmazenamentoFotos(navController: NavController) {

    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val borelFontFamily = FontFamily(
        Font(R.font.borel)
    )

    val scrollState = rememberScrollState()

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
        // Torna a Column rolável
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                .verticalScroll(scrollState) // Adiciona o scroll
        ) {
            // Alinha o botão de configuração com o texto "Dposite"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 45.dp)
                    .height(80.dp),
            ) {
                // Texto "Dposite"
                Text(
                    text = "Dposite",
                    fontSize = 60.sp,
                    fontFamily = lilyScriptOneFontFamily,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                // Botão de Configuração
                Column(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {navController.navigate("Carregamentos") },
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = Color(0xFF688AA6), // Fundo com a cor especificada
                                shape = RoundedCornerShape(12.dp) // Bordas arredondadas
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Configurações",
                            tint = Color.White // Cor do ícone
                        )
                    }
                }
            }

            // Título "Fotos Armazenados"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Fotos Armazenados",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontFamily = borelFontFamily
                )

                // Botão de Adicionar
                Column(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Green)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate("Adicionarfotos")
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add, // Ícone de +
                        contentDescription = "Adicionar",
                        tint = Color.White, // Ícone branco
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            // Imagens e seus nomes
            Column(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagem 1
                Box(modifier = Modifier.offset(50.dp, 70.dp)) {
                    Image(painter = painterResource(R.drawable.rodar), contentDescription = "Player")
                }

                // Linha 1 de imagens
                Row() {
                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imageum),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)
                                .clickable { navController.navigate("Reproduzirimagem") }

                        )
                    }

                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagedois),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)

                        )
                    }
                }

                // Linha 2 de imagens
                Row() {
                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagetre),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)
                        )
                    }

                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagequatro),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)
                        )
                    }
                }

                // Linha 3 de imagens
                Row() {
                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagecinco),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)
                        )
                    }

                    Box(
                        modifier = Modifier.size(170.dp) // Tamanho da imagem
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imageseis),  // Sua imagem
                            contentDescription = "Imagem",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(170.dp)
                        )
                    }
                }
            }
        }
    }
}
