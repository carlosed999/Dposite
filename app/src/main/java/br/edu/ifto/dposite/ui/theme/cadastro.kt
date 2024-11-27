package br.edu.ifto.dposite.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import br.edu.ifto.dposite.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cadastro() {

    val borelFontFamily = FontFamily(
        Font(R.font.borel) // Aponte para o arquivo TTF
    )

    val lilyScriptOneFontFamily = FontFamily(
        Font(R.font.lilyscriptone) // Referência ao arquivo TTF
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
            modifier = Modifier.padding(30.dp)

        ) {



            Text(
                text = "Dposite",
                fontSize = 70.sp,
                textAlign = TextAlign.Center,
                fontFamily = lilyScriptOneFontFamily,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 45.dp)
            )

            var email by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Digite Seu E-mail")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),

                value = email,
                onValueChange = {
                    email = it
                },

                //icone iniciio
                trailingIcon = ,

                shape = RoundedCornerShape(16.dp), // Bordas arredondadas
                colors = TextFieldDefaults.textFieldColors(

                    containerColor = Color(0xFFEEEEEE), // Fundo cinza claro
                    focusedIndicatorColor = Color.Transparent, // Remove linha inferior ao focar
                    unfocusedIndicatorColor = Color.Transparent // Remove linha inferior ao desfocar

            )

            )

            var senha by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Crie Sua Senha")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),


                value = senha,
                onValueChange = {
                    senha = it
                }

            )

            var confirmaSenha by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Confirme Sua Senha")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),


                value = confirmaSenha,
                onValueChange = {
                    confirmaSenha = it
                }

            )

            var name by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Digite Seu Nome")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),


                value = name,
                onValueChange = {
                    name = it
                }

            )

            var sobrenome by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Digite Seu Sobrenome")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),


                value = sobrenome,
                onValueChange = {
                    sobrenome= it
                }

            )

            var telefone by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text("Digite Seu Telefone")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),


                value = telefone,
                onValueChange = {
                    telefone= it
                }

            )

            Spacer(modifier=Modifier.weight(1f))

            Button(
                onClick = { /* Ação ao clicar no botão */ },
                colors = ButtonDefaults.buttonColors(

                    containerColor = Color.Red
                ), // Define a cor de fundo como vermelha
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Aumenta o tamanho do botão (80% da largura da tela)
                    .height(56.dp) // Define uma altura maior
                    .padding(vertical = 2.dp) // Espaçamento em volta do botão
                    .align(Alignment.CenterHorizontally), // Centraliza o botão horizontalmente
                shape = RoundedCornerShape(16.dp) // Bordas arredondadas
            ) {
                Text(
                    text = "Cadastrar",
                    color = Color.White, // Define o texto como branco
                    fontSize = 18.sp, // Aumenta o tamanho do texto
                    fontWeight = FontWeight.Bold // Adiciona negrito ao texto
                )
            }





        }

    }

}


@Preview
@Composable
fun CadastroDefault(){

    DpositeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Cadastro()

        }
}


}