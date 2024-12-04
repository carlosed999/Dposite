package br.edu.ifto.dposite
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun carregamentos() {
    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val borelFontFamily = FontFamily(
        Font(R.font.borel) // Aponte para o arquivo TTF
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            // Alinha o botão de configuração com o texto "Dposite"
            Box(
                modifier = Modifier
                        .fillMaxWidth()
                    .padding(bottom = 45.dp),
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
                IconButton(
                    onClick = { /* Ação do botão */ },
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.TopEnd)// Define o tamanho do botão
                        .background(
                            color = Color(0xFF688AA6), // Fundo com a cor especificada
                            shape = RoundedCornerShape(12.dp) // Bordas arredondadas
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Configurações",
                        tint = Color.White // Cor do ícone
                    )
                }
            }

            // Texto "Carregamentos"
            Text(
                text = "Carregamentos",
                fontSize = 42.sp,
                textAlign = TextAlign.Center,
                fontFamily = borelFontFamily,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .offset(y = 100.dp) // Move 100dp para baixo
            )


            // Adiciona os quatro quadros com as dimensões corretas
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 220.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Linha com dois quadros
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp) // Espaço entre os quadros
                ) {
                    // Quadro 1
                    Box(
                        modifier = Modifier
                            .size(160.dp, 150.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFFAB5C72), // Cor rosada
                                        Color(0xFFC25C5) // Cor lilás ou roxo
                                    ),
                                    start = Offset(0f, 0f), // Início do gradiente no canto superior esquerdo
                                    end = Offset(1f, 1f) // Gradiente indo até o canto inferior direito
                                ),
                                shape = RoundedCornerShape(20.dp) // Bordas arredondadas
                            )
                    )



                    // Quadro 2
                    Box(
                        modifier = Modifier
                            .size(160.dp, 150.dp)
                            .background(
                                color = Color(0xFF103B6D),
                                shape = RoundedCornerShape(20.dp) // Bordas arredondadas
                            )
                    )
                }

                // Espaço entre as linhas
                Spacer(modifier = Modifier.height(40.dp))

                // Linha com dois quadros
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp) // Espaço entre os quadros
                ) {
                    // Quadro 3
                    Box(
                        modifier = Modifier
                            .size(160.dp, 150.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF91334F), // Cor vinho
                                        Color(0xFFAB5C72), // Cor rosada
                                        Color(0xFF3D8BC5) // Cor azul
                                    ),
                                    start = Offset(0f, 0f), // Início do gradiente no canto superior esquerdo
                                    end = Offset(1f, 1f) // Gradiente indo até o canto inferior direito
                                ),
                                shape = RoundedCornerShape(20.dp) // Bordas arredondadas
                            )
                    )

                    // Quadro 4
                    Box(
                        modifier = Modifier
                            .size(160.dp, 150.dp)
                            .background(
                                color =  Color.Gray,
                                shape = RoundedCornerShape(20.dp) // Bordas arredondadas
                            )
                    )
                }
            }
        }
    }
}















