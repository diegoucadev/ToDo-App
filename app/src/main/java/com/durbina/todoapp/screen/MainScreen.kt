package com.durbina.todoapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.durbina.todoapp.component.ToDoComponent
import com.durbina.todoapp.data.Task

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    val tasks: MutableList<Task?> = remember {
        mutableStateListOf()
    }
    var taskText by remember {
        mutableStateOf("")
    }
    var descriptionText by remember {
        mutableStateOf("")
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
                val newTask = Task(taskText, descriptionText)
                tasks.add(newTask)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add To-Do")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = taskText,
                    placeholder = { Text(text = "Add a Task!")},
                    onValueChange = {
                    taskText = it
                })
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = descriptionText,
                    placeholder = { Text(text = "Add task description")},
                    onValueChange = {
                        descriptionText = it
                    })
            }
            LazyColumn (
                modifier = Modifier
            ){
                items(tasks) {
                    if (it != null) {
                        ToDoComponent(toDo = it.task, taskDescription = it.taskDescription)
                    }
                }
            }
        }
    }
}

