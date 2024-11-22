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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset




@Composable
fun Cadastro() {

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
                fontSize = 60.sp,
                textAlign = TextAlign.Center,
                //ontFamily = fonteBorel,
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
                    .fillMaxWidth(),


                value = email,
                onValueChange = {
                    email = it
                }
            )
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