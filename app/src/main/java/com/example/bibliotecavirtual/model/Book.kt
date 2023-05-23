package com.example.bibliotecavirtual.model

import androidx.annotation.DrawableRes

class Book(
    val name: String,
    val autor: String,
    @DrawableRes val image: Int
)
