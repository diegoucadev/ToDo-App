package com.durbina.todoapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToDoComponent(toDo: String, taskDescription: String) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Cyan)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = toDo,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            style = TextStyle(fontSize = 20.sp)

        )
        Text(
            text = "Description: $taskDescription",
            style = TextStyle(fontSize = 15.sp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
fun ToDoComponentPreview() {
    ToDoComponent(toDo = "Take out the trash", "Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit.")
}