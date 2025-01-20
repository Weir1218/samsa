package org.weir1218.samsa

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.weir1218.samsa.kafka.KafkaClient


@Composable
@Preview
fun App() {
    MaterialTheme {
        var topicName by remember { mutableStateOf("") } // State for user input
        var kafkaMessages by remember { mutableStateOf(emptyList<String>()) } // State for messages
        val kafkaClient = KafkaClient(
            mapOf(
                "group.id" to "group-weir",
            )
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = topicName,
                onValueChange = { topicName = it },
                label = { Text("Enter Topic Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(Modifier.fillMaxWidth()) {
                Button(onClick = { kafkaMessages = kafkaClient.fetchMessages(topicName) }
                ) { Text("POLL") }

                Button(onClick = { kafkaClient.destroy() }
                ) { Text("CLOSE") }
            }


        }
    }


}