// ApiService.kt
package com.example.jsonplaceholder.api

import com.example.jsonplaceholder.model.Todo
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}
