package com.example.bibliotecavirtual.ui.theme.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibliotecavirtual.dao.BookDao
import com.example.bibliotecavirtual.ui.theme.*
import com.example.bibliotecavirtual.ui.theme.components.BooksSection

class MainActivity : ComponentActivity() {

    private val dao = BookDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(
                    Intent(
                        this,
                        BookFormActivity::class.java
                    )
                )
            }) {
                val section = dao.books()
                BooksSection("Livros lidos: ", section)
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
        content: @Composable () -> Unit = {}) {
    BibliotecaVirtualTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick,
                    contentColor = Color.White,
                    backgroundColor = Color.Gray) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}