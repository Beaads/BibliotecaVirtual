package com.example.bibliotecavirtual.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotecavirtual.ui.theme.BibliotecaVirtualTheme

class BookFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaVirtualTheme {
                Surface {
                    BookFormScreen()

                }
            }
        }
    }
}

@Composable
fun BookFormScreen(){
    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)){
        Text(
            text = "Crie um livro",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp)

        var url by remember {
            mutableStateOf("")
        }
        TextField(value = url, onValueChange = {
            url = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Url da imagem")
        })

        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = {
            name = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Nome")
        })

        var descricao by remember {
            mutableStateOf("")
        }
        TextField(value = descricao, onValueChange = {
            descricao = it
        }, Modifier.fillMaxWidth()
            .heightIn(min = 100.dp),
            label = { Text(text = "Descrição")
        },
        )
        Button(onClick = { }, Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            elevation = ButtonDefaults.elevation(3.dp),) {
            Text(text = "Salvar", fontWeight = FontWeight(700))
        }
    }
}

@Preview
@Composable
fun bookFormScreenPreview() {
    BibliotecaVirtualTheme {
        Surface {
            BookFormScreen()
        }
    }
}