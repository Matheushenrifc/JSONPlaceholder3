package com.example.jsonplaceholder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholder.api.RetrofitInstance
import com.example.jsonplaceholder.model.Todo
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class TodoViewModel : ViewModel() {
    private val _todos = mutableStateOf<List<Todo>>(emptyList())
    val todos: State<List<Todo>> get() = _todos

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTodos()
                _todos.value = response
            } catch (e: Exception) {
                // Log de erro (opcional)
            }
        }
    }
}
