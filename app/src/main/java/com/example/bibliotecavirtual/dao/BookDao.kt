package com.example.bibliotecavirtual.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.bibliotecavirtual.model.Book

class BookDao {
    companion object {
        private val books = mutableStateListOf<Book>()
    }
    fun books() = books.toList()

    fun save(book: Book) {
        books.add(book)
    }
}