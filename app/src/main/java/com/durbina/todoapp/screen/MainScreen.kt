package com.durbina.todoapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.durbina.todoapp.component.ToDoComponent
import com.durbina.todoapp.component.ToDoComponentPreview
import com.durbina.todoapp.data.Task

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val tasks: MutableList<Task?> = remember {
        mutableStateListOf()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan
                ),
                title = { Text(text = "Simple To-do App", color = Color.Black)}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                tasks.add(Task("Take out the trash!", "Lorem ipsum dolor sit amet," +
                        " consectetur adipiscing elit."))
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add To-Do")
            }
        }
    ) { innerPadding ->
        Column() {

        }
        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
        ){
            items(tasks) {
                if (it != null) {
                    ToDoComponent(toDo = it.task, taskDescription = it.taskDescription)
                }
            }
        }

    }
}

