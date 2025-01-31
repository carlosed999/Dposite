package br.edu.ifto.dposite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun Armazenamentovideo(navController: NavController) {

    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val borelFontFamily = FontFamily(
        Font(R.font.borel)
    )

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
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        // Alinha o botão de configuração com o texto "Dposite"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 45.dp)
                .height(80.dp),

            // Alinha verticalmente ao centro
        )
        {
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
                    onClick = { navController.navigate("Carregamentos")},
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text =
                "       Vídeos\n Armazenados",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = borelFontFamily
            )

            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green)
                    .padding(5.dp)
                    .clickable {
                        navController.navigate("Adicionarvideos")

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
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.offset(50.dp, 70.dp)) {
                Image(painter = painterResource(R.drawable.rodar), contentDescription = "Player")
            }
            Row() {
                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imageum),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            navController.navigate("Reproduzirvideo")
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-14).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White, // Cor do ícone
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imagedois),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            // Adicione aqui a ação que você deseja quando clicar no botão de play
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-14).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)// Cor do ícone
                        )
                    }
                }

            }

            Row() {

                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imagetre),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            // Adicione aqui a ação que você deseja quando clicar no botão de play
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-14).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)// Cor do ícone
                        )
                    }
                }


                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imagequatro),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)// A imagem preenche todo o espaço do Box
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            // Adicione aqui a ação que você deseja quando clicar no botão de play
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-14).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)// Cor do ícone
                        )
                    }
                }
            }
            Row() {


                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imagecinco),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            // Adicione aqui a ação que você deseja quando clicar no botão de play
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-10).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)// Cor do ícone
                        )
                    }
                }

                Box(
                    modifier = Modifier.size(170.dp) // Tamanho da imagem
                ) {
                    // A imagem de fundo
                    Image(
                        painter = painterResource(id = R.drawable.imageseis),  // Sua imagem
                        contentDescription = "Imagem",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(170.dp)
                            .size(170.dp)
                    )

                    // O botão Play no canto inferior direito
                    IconButton(
                        onClick = {
                            // Adicione aqui a ação que você deseja quando clicar no botão de play
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-10).dp)// Alinha o botão no canto inferior direito
                            .zIndex(1f) // Garante que o ícone fique sobre a imagem
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,  // Ícone de play
                            contentDescription = "Botão Play",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)// Cor do ícone
                        )
                    }
                }
            }
        }

    }
}
