package br.edu.ifto.dposite

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.Parameters
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.forms.submitForm
import kotlinx.serialization.json.Json

@Serializable
data class Usuario (val id: Int, val nome: String)

@Serializable
data class Resposta (val usuario: Usuario?, val mensagem: String)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var resposta by remember { mutableStateOf(Resposta(null, "") ) }


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
            modifier = Modifier.padding(30.dp)

        ) {


            Text(
                text = "Dposite",
                fontSize = 96.sp,
                textAlign = TextAlign.Center,
                fontFamily = lilyScriptOneFontFamily,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 45.dp)
            )

            Text(
                text = "login",
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontFamily = borelFontFamily,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )

            var email by remember { mutableStateOf("") }


            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = {
                        Text(
                            text = "Digite Seu E-mail",
                            style = TextStyle(
                                fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(top = 10.dp) // Alinha o placeholder ao centro
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        ),

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "E-mail Icon",
                            tint = Color.White
                        )
                    },
                    shape = RoundedCornerShape(16.dp), // Bordas arredondadas
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0x11000000), // Fundo cinza claro
                        focusedIndicatorColor = Color.Transparent, // Remove linha inferior ao focar
                        unfocusedIndicatorColor = Color.Transparent // Remove linha inferior ao desfocar
                    )
                )
            }

            var senha by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text(
                        text = "Digite Sua Senha",
                        style = TextStyle(
                            fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                            fontSize = 14.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top = 10.dp) // Alinha o placeholder ao centro
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(20.dp)),

                value = senha,
                onValueChange = {
                    senha = it
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Cadeado Icon",
                        tint = Color.White
                    )
                },
                shape = RoundedCornerShape(16.dp), // Bordas arredondadas
                colors = TextFieldDefaults.textFieldColors(

                    containerColor = Color(0x11000000), // Fundo cinza claro
                    focusedIndicatorColor = Color.Transparent, // Remove linha inferior ao focar
                    unfocusedIndicatorColor = Color.Transparent // Remove linha inferior ao desfocar
                )


            )

            Button(


                onClick = {

                    navController.navigate("Carregamentos")

                    val client = HttpClient(CIO)

                    runBlocking {
                        val json : HttpResponse = client.submitForm(
                            url = "http://10.3.0.99/dposite/cadastro/controle/usuario/login_json.php",
                            formParameters = Parameters.build {
                                append("email", email)
                                append("senha", senha)
                            }
                        )

                        var resp = json.readText()
                        resposta = Json.decodeFromString<Resposta>(resp)


                        navController.navigate("Carregamentos")
                    }







                          },
                colors = ButtonDefaults.buttonColors(

                    containerColor = Color.Gray
                ), // Define a cor de fundo como vermelha
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Aumenta o tamanho do botão (80% da largura da tela)
                    .height(56.dp) // Define uma altura maior
                    .padding(vertical = 2.dp) // Espaçamento em volta do botão
                    .align(Alignment.CenterHorizontally)
                    .border(2.dp, Color.White, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),// Bordas arredondadas
            ) {

                Text(
                    text = "Login",
                    fontFamily = borelFontFamily, // Fonte Boreal
                    color = Color.White, // Cor do texto
                    fontSize = 22.sp, // Tamanho do texto
                    fontWeight = FontWeight.Bold, // Negrito
                    modifier = Modifier.padding(top = 5.dp) // Centraliza o texto

                )

            }
            if(resposta != null && resposta!!.usuario != null){
                Text(text = resposta!!.usuario!!.nome)
            }
            Text(
                text = resposta.mensagem
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Texto "Ou Entre Com"
                Text(
                    text = "Ou Entre Com",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = borelFontFamily,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 45.dp)
                        .padding(top = 25.dp) // Ajusta o espaço superior
                )

                // Row para os ícones de login
                Row(
                    horizontalArrangement = Arrangement.Center, // Alinha os ícones no centro
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Ícone Google
                    IconButton(onClick = { navController.navigate("Carregamentos") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Login",
                            tint = Color.White, // Cor do ícone
                            modifier = Modifier.size(40.dp) // Tamanho do ícone
                        )
                    }

                    // Ícone Facebook
                    IconButton(onClick = { navController.navigate("Carregamentos") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook Login",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    // Ícone Instagram
                    IconButton(onClick = { navController.navigate("Carregamentos") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.instagram),
                            contentDescription = "Instagram Login",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }


            }


        }

    }

}





