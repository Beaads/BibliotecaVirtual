package com.example.bibliotecavirtual.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibliotecavirtual.sampleData.sampleBooks
import com.example.bibliotecavirtual.ui.theme.*
import com.example.bibliotecavirtual.ui.theme.components.BooksSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    BibliotecaVirtualTheme {
        Surface {
            BooksSection("Livros lidos: ", sampleBooks)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}