package com.example.jsonplaceholder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jsonplaceholder.model.Todo
import com.example.jsonplaceholder.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.clickable


@Composable
fun TodoScreen(
    viewModel: TodoViewModel = viewModel(),
    onTodoClick: (Todo) -> Unit
) {
    val todos = viewModel.todos.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(todos) { todo ->
            TodoItem(todo = todo, onClick = { onTodoClick(todo) })
        }
    }
}

@Composable
fun TodoItem(todo: Todo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${todo.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = if (todo.completed) "✔️ Completo" else "❌ Incompleto",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
