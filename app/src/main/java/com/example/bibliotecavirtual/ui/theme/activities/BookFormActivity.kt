package com.example.bibliotecavirtual.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bibliotecavirtual.model.Book
import com.example.bibliotecavirtual.R
import com.example.bibliotecavirtual.dao.BookDao
import com.example.bibliotecavirtual.ui.theme.BibliotecaVirtualTheme

class BookFormActivity : ComponentActivity() {

    private val dao = BookDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaVirtualTheme {
                Surface {
                    BookFormScreen(onSaveClick = { book ->
                        dao.save(book)
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun BookFormScreen(onSaveClick: (Book) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Crie um livro",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp
        )
        var url by remember {
            mutableStateOf("")
        }
        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }
        TextField(value = url, onValueChange = {
            url = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Url da imagem")
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = {
            name = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Nome")
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ))

        var descricao by remember {
            mutableStateOf("")
        }
        TextField(
            value = descricao,
            onValueChange = {
                descricao = it
            },
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = {
                val book = Book(
                    name = name,
                    descricao = descricao,
                    image = url
                )
                onSaveClick(book)
            },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            elevation = ButtonDefaults.elevation(3.dp),
        ) {
            Text(text = "Salvar", fontWeight = FontWeight(700))
        }
        Spacer(modifier = Modifier)
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