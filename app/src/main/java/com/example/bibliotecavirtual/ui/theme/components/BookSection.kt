package com.example.bibliotecavirtual.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotecavirtual.model.Book
import com.example.bibliotecavirtual.sampleData.sampleBooks

@Composable
fun BooksSection(
    title: String,
    books: List<Book>
) {
    Column(
        Modifier
            .fillMaxHeight()
    ) {
        Text(
            text = title,
            Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Column(
            Modifier
                .padding(start = 10.dp, end = 8.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(Modifier)
            for (b in books) {
                BookItem(book = b)
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BooksSectionPreview() {
    BooksSection("Livros lidos", books = sampleBooks)

}

