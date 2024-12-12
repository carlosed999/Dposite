package br.edu.ifto.dposite.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.zIndex
import br.edu.ifto.dposite.R

@Composable
fun Favoritos(){

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


    //Icones de Favoritos Nas Midias
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(35.dp, 300.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Um",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(200.dp, 300.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Dois",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(35.dp, 425.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Três",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(200.dp, 425.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Quatro",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(35.dp, 553.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Cinco",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(200.dp, 553.dp)
            .size(40.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito Imagem Seis",
        tint = Color.White // Cor do ícone
    )
    //Icones de Player Nas Midias
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(145.dp, 365.dp)
            .size(40.dp),
        imageVector = Icons.Default.PlayArrow,
        contentDescription = "Player Imagem Um",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(145.dp, 630.dp)
            .size(40.dp),
        imageVector = Icons.Default.PlayArrow,
        contentDescription = "Player Imagem Dois",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(310.dp, 365.dp)
            .size(40.dp),
        imageVector = Icons.Default.PlayArrow,
        contentDescription = "Player Imagem Dois",
        tint = Color.White // Cor do ícone
    )
    Icon(
        modifier = Modifier.zIndex(1f)
            .offset(310.dp, 500.dp)
            .size(40.dp),
        imageVector = Icons.Default.PlayArrow,
        contentDescription = "Player Imagem Quatro",
        tint = Color.White // Cor do ícone
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
                    .fillMaxWidth()
                    .padding(end = 50.dp),
                textAlign = TextAlign.Center

            )

            // Botão de Configuração
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center

            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .padding(top = 20.dp)
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
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text =
            "Favoritos",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = borelFontFamily)
        }
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box (modifier = Modifier
                .offset(1.dp, 30.dp) ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.imgum),
                        contentDescription = "ImagemUm",
                        modifier = Modifier
                            .width(160.dp)
                            .height(160.dp)
                            .padding(end = 5.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.imgdois),
                        contentDescription = "ImagemDois",
                        modifier = Modifier.width(160.dp)
                            .height(160.dp)
                    )
                }
            }
            Row (modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(R.drawable.imgtres), contentDescription = "ImagemTrês"
                    , modifier = Modifier
                        .padding(end = 5.dp)
                        .width(160.dp)
                        .height(160.dp))
                Image(painter = painterResource(R.drawable.imgquatro), contentDescription = "ImagemQuatro"
                    , modifier = Modifier
                        .width(160.dp)
                        .height(160.dp))
            }
            Box {
                Row(modifier = Modifier.fillMaxWidth()
                        .offset(0.dp, -30.dp)) {
                    Image(
                        painter = painterResource(R.drawable.imgcinco),
                        contentDescription = "ImagemCinco",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .width(160.dp)
                            .height(160.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.imgseis),
                        contentDescription = "ImagemSeis",
                        modifier = Modifier
                            .width(160.dp)
                            .height(160.dp)
                    )
                }
            }
        }
    }
}