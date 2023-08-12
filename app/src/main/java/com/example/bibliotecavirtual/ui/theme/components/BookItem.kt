package com.example.bibliotecavirtual.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bibliotecavirtual.model.Book
import com.example.bibliotecavirtual.ui.theme.DarkGray
import com.example.bibliotecavirtual.ui.theme.Gray
import com.example.bibliotecavirtual.R

@Composable
fun BookItem(book: Book) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(2.dp, 200.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(85.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Gray, DarkGray
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 85.dp, top = 20.dp, end = 10.dp)
                ) {
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = book.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = book.descricao,
                        Modifier.padding(top = 3.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                AsyncImage(
                    model = book.image,
                    contentDescription = null,
                    Modifier
                        .size(65.dp)
                        .offset(x = 10.dp, y = 0.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.CenterStart),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookItemPreview() {
    BookItem(
        Book(
            name = LoremIpsum(50).values.first(),
            descricao = LoremIpsum(50).values.first()
        )
    )
}
