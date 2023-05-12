package com.example.bibliotecavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotecavirtual.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaVirtualTheme {
                Surface {
                    BooksSection()
                }
            }
        }
    }
}

@Composable
fun BooksSection() {
    Column(Modifier
        .fillMaxHeight()) {
        Text(
            text = "Livros lidos: ",
            Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400))
        Column(
            Modifier
                .padding(start = 10.dp, end = 8.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Spacer(Modifier)
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            BookItem()
            Spacer(Modifier)
        }
    }
}


@Composable
fun BookItem() {
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
                        text = LoremIpsum(50).values.first(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = LoremIpsum(50).values.first(),
                        Modifier.padding(top = 3.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(65.dp)
                        .offset(x = 10.dp, y = 0.dp)
                        .clip(shape = CircleShape)
                        .align(CenterStart)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BooksSectionPreview() {
    BooksSection()
}

@Preview(showBackground = true)
@Composable
private fun BookItemPreview() {
    BookItem()
}