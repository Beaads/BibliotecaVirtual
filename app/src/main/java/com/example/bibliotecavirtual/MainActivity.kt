package com.example.bibliotecavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotecavirtual.ui.theme.BibliotecaVirtualTheme
import com.example.bibliotecavirtual.ui.theme.Purple500
import com.example.bibliotecavirtual.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaVirtualTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    BookItem()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookItem() {
    Column(Modifier
        .height(45.dp)
        .width(200.dp)) {
        Box(modifier = Modifier
            .height(50.dp)
            .background(brush = Brush.horizontalGradient(colors = listOf(
                Purple500, Teal200
            )))
            .fillMaxWidth()) {
            Row (){
                Spacer(modifier = Modifier.width(40.dp))
                Text(text = "Texto 1")
            }

            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                Modifier.size(30.dp)
                    .offset(x = 5.dp, y = 0.dp)
                    .clip(shape = CircleShape)
                    .align(CenterStart))
        }
    }
}