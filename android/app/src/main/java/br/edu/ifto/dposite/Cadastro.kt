package br.edu.ifto.dposite

import android.util.Log
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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import br.edu.ifto.dposite.ui.theme.DpositeTheme
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.forms.submitForm
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.Parameters
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val borelFontFamily = FontFamily(
    Font(R.font.borel) // Aponte para o arquivo TTF
)
@Serializable
data class NovoUsuario(val email: String, val nome: String, val sobrenome: String, val telefone: String)

@Serializable
data class RespCadastro(val mensagem: String, val status: String, val usuario: NovoUsuario?)


//{"status":"sucesso","mensagem":"Salvo com sucesso!","usuario":{"email":"ds@gmail.com","nome":"","sobrenome":"zn","telefone":"12334"}}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cadastro(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var respp by remember { mutableStateOf(RespCadastro("", "", null) ) }


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

            Text(
                text = respp.mensagem,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.White
            )


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
                            modifier = Modifier.padding(top=10.dp) // Alinha o placeholder ao centro
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                        .border(width = 2.dp,color=Color.White, shape =  RoundedCornerShape(20.dp)),

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
                        text = "Crie Sua Senha",
                        style = TextStyle(
                            fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                            fontSize = 14.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top=10.dp) // Alinha o placeholder ao centro
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .border(width = 2.dp,color=Color.White, shape =  RoundedCornerShape(20.dp)),

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

            var confirmaSenha by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text(
                        text = "Confirma Sua Senha",
                        style = TextStyle(
                            fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                            fontSize = 14.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top=10.dp) // Alinha o placeholder ao centro
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .border(width = 2.dp,color=Color.White, shape =  RoundedCornerShape(20.dp)),


                value = confirmaSenha,
                onValueChange = {
                    confirmaSenha = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.LockOpen,
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

            var name by remember { mutableStateOf("") }

            TextField(
                placeholder = {
                    Text(
                        text = "Digite Seu Nome",
                        style = TextStyle(
                            fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                            fontSize = 14.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top=10.dp) // Alinha o placeholder ao centro
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .border(width = 2.dp,color=Color.White, shape =  RoundedCornerShape(20.dp)),

                value = name,
                onValueChange = {
                    name = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Pessoa Icon",
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

            var sobrenome by remember { mutableStateOf("") }

            Campo(
                texto = "Digite Seu Sobrenome",
                valor = sobrenome,
                aoMudar = {
                    sobrenome= it
                },
                icone = Icons.Filled.Person
            )


            var telefone by remember { mutableStateOf("") }

            Campo(
                texto = "Digite Seu Telefone",
                valor = telefone,
                aoMudar = {
                    telefone= it
                },
                icone = Icons.Filled.Phone
            )



            Spacer(modifier=Modifier.weight(1f))

            Button(


                onClick = { //navController.navigate("Carregamentos")



                        val client = HttpClient(CIO)

                        runBlocking {
                            val json : HttpResponse = client.submitForm(
                                url = "http://10.3.0.99/dposite/cadastro/controle/usuario/cadastrar_json.php",
                                formParameters = Parameters.build {
                                    append("email", email)
                                    append("senha", senha)
                                    append("telefone", telefone)
                                    append("nome", nome)
                                    append("sobrenome", sobrenome)

                                }
                            )

                            var resp = json.readText()
                            Log.d("meu", resp)
                            respp = Json.decodeFromString<RespCadastro>(resp)



                        }

                   },
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
                        fontFamily = borelFontFamily, // Fonte Boreal
                        color = Color.White, // Cor do texto
                        fontSize = 18.sp, // Tamanho do texto
                        fontWeight = FontWeight.Bold, // Negrito
                        modifier = Modifier.padding(top=5.dp) // Centraliza o texto


                    )

            }





        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Campo(
    texto: String,
    valor: String,
    aoMudar: (String) -> Unit,
    icone:ImageVector
){
    TextField(
        placeholder = {
            Text(texto,
                style = TextStyle(
                    fontFamily = borelFontFamily, // Use a fonte Boreal aqui
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(top=10.dp) // Alinha o placeholder ao centro)
            )
                      },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
            .border(width = 2.dp,color=Color.White, shape =  RoundedCornerShape(20.dp)),
        value = valor,
        onValueChange = aoMudar,
        leadingIcon = {
            Icon(
                imageVector = icone,
                contentDescription = "Pessoa Icon",
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


@Preview
@Composable
fun CadastroDefault(){

    DpositeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

        }
    }


}
