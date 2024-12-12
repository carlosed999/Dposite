package br.edu.ifto.dposite

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment.Companion as Alignment1

@Composable
fun Armazenamento(){

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
    Column {
        Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment1.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text( text = "Dposite",
                fontSize = 70.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = lilyScriptOneFontFamily,
                modifier = Modifier
                    .fillMaxWidth())
        }

        
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp), horizontalArrangement = Arrangement.Center) {
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
        Column (modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Box (modifier = Modifier.offset(50.dp, 70.dp)) {
                Image(painter = painterResource(R.drawable.rodar), contentDescription = "Player")
            }
            Row (){
                Image(painter = painterResource(R.drawable.imageum), contentDescription ="Imagem"
                    , modifier = Modifier.size(180.dp))
                Image(painter = painterResource(R.drawable.imagedois), contentDescription ="Imagem"
                    , modifier = Modifier
                        .padding(start = 10.dp)
                        .size(180.dp))

            }

            Row () {

                Image(painter = painterResource(R.drawable.imagetre), contentDescription ="Imagem"
                    , modifier = Modifier.size(180.dp) )
                Image(painter = painterResource(R.drawable.imagequatro), contentDescription ="Imagem"
                    , modifier = Modifier
                        .padding(start = 10.dp)
                        .size(180.dp)
                        .size(180.dp))
            }
            Row () {

                Image(painter = painterResource(R.drawable.imagecinco), contentDescription ="Imagem"
                    , modifier = Modifier.size(180.dp))
                Image(painter = painterResource(R.drawable.imageseis), contentDescription ="Imagem"
                    , modifier = Modifier
                        .padding(start = 10.dp)
                        .size(180.dp)
                        .size(180.dp))
            }
        }

    }
}
