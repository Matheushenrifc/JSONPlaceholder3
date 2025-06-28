package com.example.jsonplaceholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.jsonplaceholder.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jsonplaceholder.navigation.AppNavigation



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: TodoViewModel = viewModel()
                AppNavigation(viewModel)
            }
        }
    }
}
