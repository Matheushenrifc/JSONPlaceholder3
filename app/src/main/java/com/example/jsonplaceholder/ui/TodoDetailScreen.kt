@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jsonplaceholder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jsonplaceholder.model.Todo
import androidx.compose.foundation.layout.padding


@Composable
fun TodoDetailScreen(todo: Todo) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalhes do Todo") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("ID: ${todo.id}")
            Text("Usuário: ${todo.userId}")
            Text("Título: ${todo.title}")
            Text("Status: ${if (todo.completed) "✔️ Completo" else "❌ Incompleto"}")
        }
    }
}