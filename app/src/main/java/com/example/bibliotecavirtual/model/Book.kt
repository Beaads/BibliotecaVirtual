package com.example.bibliotecavirtual.model

data class Book(
    val id: Int,
    var name: String,
    var descricao: String,
    var image: String? = null
)
