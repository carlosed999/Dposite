package br.edu.ifto.dposite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Perfil (navController: NavController) {

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
    )

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (modifier = Modifier
            .align(Alignment.End)
            .padding(end = 20.dp)
            .padding(top = 35.dp)){
            Button(onClick = { navController.navigate("Carregamentos") }, modifier = Modifier.heightIn(min = 10.dp, max = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff688AA6)
                )
            )
            {
                Image(painter = painterResource(id = R.drawable.home), contentDescription = "Botão Home")
            }
        }
        Column (modifier = Modifier.padding(top = 50.dp)) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.perfil),
                    contentDescription = "Foto de Perfil",
                    alignment = Alignment.Center
                )
            }
            Row ( horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()){
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Nome de Usúario",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontFamily = borelFontFamily
                )
            }
        }

        //Suas informações
        Column (modifier = Modifier.padding(top = 100.dp)) {

            Informacao(texto = "Suas Informações", icone = painterResource(id = R.drawable.iconeinfo))
            Informacao(texto = "user@gmail.com", icone = painterResource(id = R.drawable.email))
            Informacao(texto = "(63) 90000-0000", icone = painterResource(id = R.drawable.telefone))
            Informacao(texto = "Alterar Informações", icone = painterResource(id = R.drawable.editar))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { },modifier = Modifier
            .padding(bottom = 70.dp)
            .padding(start = 20.dp)
            .align(Alignment.Start)
            .border(2.dp, Color.White, RoundedCornerShape(20.dp))
            .heightIn(min = 20.dp, max = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff688AA6),
            )
        )
        {
            Text(
                text = "Sair",
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = borelFontFamily
            ) // Conteúdo do botão
        }
    }
}

@Composable


fun Informacao(texto: String, icone: Painter){

    val borelFontFamily = FontFamily(
        Font(R.font.borel) // Aponte para o arquivo TTF
    )

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Image(
            painter = icone,
            contentDescription = "Editar",
            modifier = Modifier.size(30.dp)
        )
        Text( modifier = Modifier
            .padding(start = 10.dp)
            .width(300.dp),
            text = texto,
            fontSize = 25.sp,
            fontFamily = borelFontFamily,
            color = Color.White)


    }
}