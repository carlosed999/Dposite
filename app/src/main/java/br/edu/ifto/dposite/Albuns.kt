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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
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
import br.edu.ifto.dposite.ui.theme.Criaralbum

@Composable
fun Albuns(navController: NavController) {

    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val borelFontFamily = FontFamily(
        Font(R.font.borel)
    )

    // Cria o estado de rolagem
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
    )

    // Usando verticalScroll para permitir que a tela seja rolada para baixo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(scrollState) // Tornando a tela rolável
    ) {
        // Alinha o botão de configuração com o texto "Dposite"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 45.dp)
                .height(80.dp),
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
                    onClick = ( { navController.navigate("Carregamentos") } ),
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
                text = "   Álbuns    ",
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = borelFontFamily
            )

            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green)
                    .padding(5.dp)
                    .clickable { navController.navigate("Criaralbum") }
            ) {
                Icon(
                    imageVector = Icons.Default.Add, // Ícone de "+"
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

            // Primeira linha de imagens
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
            ) {
                // Nome "Animais"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Animais",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Animais"
                                println("Imagem Animais clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imageum),
                            contentDescription = "Imagem Animais",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }

                // Nome "Lugares"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Lugares",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Lugares"
                                println("Imagem Lugares clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagedois),
                            contentDescription = "Imagem Lugares",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }
            }

            // Segunda linha de imagens
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
            ) {
                // Nome "Esportes"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Esportes",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Esportes"
                                println("Imagem Esportes clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagetre),
                            contentDescription = "Imagem Esportes",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }

                // Nome "Casas"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Casas",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Casas"
                                println("Imagem Casas clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagequatro),
                            contentDescription = "Imagem Casas",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }
            }

            // Terceira linha de imagens
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
            ) {
                // Nome "Casamentos"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Casamentos",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Casamentos"
                                println("Imagem Casamentos clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imagecinco),
                            contentDescription = "Imagem Casamentos",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }

                // Nome "Memórias"
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Memórias",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = borelFontFamily // Usando a fonte "Borel"
                    )
                    Box(
                        modifier = Modifier
                            .size(170.dp)
                            .clickable {
                                // Ação ao clicar na imagem "Memórias"
                                println("Imagem Memórias clicada!")
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.imageseis),
                            contentDescription = "Imagem Memórias",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }
            }
        }
    }
}
