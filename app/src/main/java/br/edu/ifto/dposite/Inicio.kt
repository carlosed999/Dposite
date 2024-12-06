package br.edu.ifto.dposite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Inicio(navController: NavController) {



    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
    )
    val fredokaFontFamily = FontFamily(
        Font(R.font.fredoka)
    )
    val interFontFamily = FontFamily(
        Font(R.font.inter)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAB1B02))
    )
//Imagens de Fundo
    Box (modifier = Modifier
        .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fundoum), // Substitua pelo seu recurso de imagem
            contentDescription = "Imagem aumentada",
            modifier = Modifier.size(300.dp).
            padding(start = 70.dp).
            padding(bottom = 50.dp).
            align(alignment = Alignment.Center)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fundodois), // Substitua pelo seu recurso de imagem
            contentDescription = "Imagem aumentada",
            modifier = Modifier.size(200.dp)
                .offset(5.dp, 450.dp)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.fundotres), // Substitua pelo seu recurso de imagem
            contentDescription = "Imagem aumentada",
            modifier = Modifier.size(200.dp)
                .offset(150.dp, 580.dp)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.elipse), // Substitua pelo seu recurso de imagem
            contentDescription = "Imagem aumentada",
            modifier = Modifier.size(200.dp)
                .offset(10.dp, 20.dp)
        )
    }


//Titulo
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp,)
        .padding(bottom = 20.dp)) {
        Text(
            text = "Dposite",
            fontSize = 70.sp,
            textAlign = TextAlign.Center,
            fontFamily = lilyScriptOneFontFamily,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth())

        //Frases do Inicio
        Column (modifier = Modifier.padding(top = 20.dp)){
            Text(
                text = "Salve seus videos e imagens favoritas em um só lugar",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                lineHeight = 42.sp,
                fontFamily = lilyScriptOneFontFamily,
                color = Color.White)
            (
                    Text(
                        text = "Crie já sua \nconta\n GRÁTIS",
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        lineHeight = 55.sp,
                        fontFamily = fredokaFontFamily,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                            .offset(-1.dp, 1.dp)
                    )
                    )
        }

        //Botões
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                modifier = Modifier
                    .size(190.dp, 65.dp)
                    .padding(bottom = 10.dp)
                    .border(2.dp, Color.White, shape = RoundedCornerShape(30.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF4DA524)),
                shape = RoundedCornerShape(30.dp),
                onClick = {navController.navigate("Login")}
            ) {
                Text(
                    text="Entrar",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = interFontFamily)
            }
            Text(
                text="Ou",
                fontSize = 25.sp,
                color = Color.White,
                fontFamily = lilyScriptOneFontFamily)
            Button(
                modifier = Modifier
                    .size(190.dp, 65.dp)
                    .padding(top = 10.dp)
                    .border(2.dp, Color.White, shape = RoundedCornerShape(30.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xEC0004)),
                shape = RoundedCornerShape(30.dp),
                onClick = {navController.navigate("Cadastro")}
            ) {
                Text(
                    text="Cadastrar",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = interFontFamily)
            }

        }

    }
}