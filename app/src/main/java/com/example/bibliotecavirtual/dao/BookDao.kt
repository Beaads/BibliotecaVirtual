package com.example.bibliotecavirtual.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.bibliotecavirtual.model.Book

class BookDao {
    companion object {
        private val books = mutableStateListOf<Book>()
        private var nextId = 1
    }
    fun books() = books.toList()

        fun save(book: Book): Int {
            val newId = nextId
            nextId++
            books.add(book.copy(id = newId))
            return newId
        }

    fun getBookById(bookId: Int): Book? {
        return books.find { it.id == bookId }

    }

    fun update(bookId: Int, updatedBook: Book) {
        val existingBook = books.find { it.id == bookId }
        existingBook?.apply {
            name = updatedBook.name
            descricao = updatedBook.descricao
            image = updatedBook.image
        }
        }
}