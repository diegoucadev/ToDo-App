package com.durbina.todoapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val tasks: MutableList<Task> = remember { mutableStateListOf() }
    var taskName by remember { mutableStateOf(TextFieldValue()) }
    var taskDescription by remember { mutableStateOf(TextFieldValue()) }
    val dialogState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan
                ),
                title = { Text(text = "Simple To-do App", color = Color.Black) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                dialogState.value = true
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add To-Do")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(tasks) { task ->
                    ToDoComponent(toDo = task.task, taskDescription = task.taskDescription)
                }
            }
        }

        if (dialogState.value) {
            AlertDialog(
                onDismissRequest = {
                    dialogState.value = false
                    taskName = TextFieldValue()
                    taskDescription = TextFieldValue()
                },
                title = { Text("Add Task") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = taskName,
                            onValueChange = { taskName = it },
                            label = { Text("Task Name") }
                        )
                        OutlinedTextField(
                            value = taskDescription,
                            onValueChange = { taskDescription = it },
                            label = { Text("Task Description") }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            tasks.add(Task(taskName.text, taskDescription.text))
                            dialogState.value = false
                            taskName = TextFieldValue()
                            taskDescription = TextFieldValue()
                        }
                    ) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogState.value = false
                            taskName = TextFieldValue()
                            taskDescription = TextFieldValue()
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

data class Task(val task: String, val taskDescription: String)

@Composable
fun ToDoComponent(toDo: String, taskDescription: String) {
    Column {
        Text(text = toDo)
        Text(text = taskDescription)

    }
}



