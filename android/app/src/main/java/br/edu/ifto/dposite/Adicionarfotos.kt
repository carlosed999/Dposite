package br.edu.ifto.dposite.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.edu.ifto.dposite.R

@Composable
fun Adicionarfotos(navController: NavController){

    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val borelFontFamily = FontFamily(
        Font(R.font.borel)
    )
    val corfundobox = Color(0x52390C0C)

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
                    .fillMaxWidth().padding(end = 50.dp),
                textAlign = TextAlign.Center

            )

            // Botão de Configuração
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxHeight().padding(start = 20.dp),
                verticalArrangement = Arrangement.Center

            ) {
                IconButton(
                    onClick = { navController.navigate("Carregamentos")},
                    modifier = Modifier
                        .size(48.dp).padding(top = 20.dp)
                        .background(
                            color = Color(0xFF688AA6), // Fundo com a cor especificada
                            shape = RoundedCornerShape(12.dp) // Bordas arredondadas
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "home",
                        tint = Color.White // Cor do ícone
                    )
                }
            }
        }


        //Nome Adicionar
        Column (modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text =
            "Adicionar Fotos",
                color = Color.White,
                fontSize = 25.sp,
                fontFamily = borelFontFamily)
        }

        //Caixa de Adiconar
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
           Box(modifier = Modifier
               .padding(top = 50.dp)
               .fillMaxWidth()
               .width(370.dp) // Define a largura
               .height(200.dp)
               .clip(RoundedCornerShape(30.dp))
               .background(corfundobox), contentAlignment = Alignment.TopCenter){
               Column(modifier = Modifier
                   .fillMaxWidth()
                   .padding(top = 20.dp)
                   , horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                   Text(
                       text = "Adicionar Imagens",
                       fontFamily = borelFontFamily,
                       fontSize = 25.sp,
                       color = Color.White

                   )
                   Image(
                       modifier = Modifier.size(200.dp),
                       painter = painterResource(R.drawable.imagemgaleria),
                       contentDescription = "Imagem Galeria"
                   )
               }
           }
        }

        //Botões
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                modifier = Modifier
                    .size(190.dp, 65.dp)
                    .padding(bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF4DA524)),
                shape = RoundedCornerShape(30.dp),
                onClick = {}
            ) {
                Text(
                    text="Adicionar",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = borelFontFamily)
            }

            Button(
                modifier = Modifier
                    .size(190.dp, 65.dp)
                    .padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFC0000)),
                shape = RoundedCornerShape(30.dp),
                onClick = {}
            ) {
                Text(
                    text="Cancelar",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = borelFontFamily)
            }

        }
    }
}