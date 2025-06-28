package com.example.jsonplaceholder.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.example.jsonplaceholder.model.Todo
import com.example.jsonplaceholder.ui.TodoDetailScreen
import com.example.jsonplaceholder.ui.TodoScreen
import com.example.jsonplaceholder.viewmodel.TodoViewModel

@Composable
fun AppNavigation(viewModel: TodoViewModel) {
    val navController = rememberNavController()
    val todos = viewModel.todos.value

    NavHost(navController = navController, startDestination = Screens.TodoList.name) {
        composable(Screens.TodoList.name) {
            TodoScreen(viewModel = viewModel) { selectedTodo ->
                navController.currentBackStackEntry?.savedStateHandle?.set("todo", selectedTodo)
                navController.navigate(Screens.TodoDetail.name)
            }
        }

        composable(Screens.TodoDetail.name) {
            val todo = navController.previousBackStackEntry
                ?.savedStateHandle?.get<Todo>("todo")

            todo?.let {
                TodoDetailScreen(todo = it)
            }
        }
    }
}
