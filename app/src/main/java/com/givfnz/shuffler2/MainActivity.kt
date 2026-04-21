package com.givfnz.shuffler2

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.givfnz.shuffler2.ui.theme.Shuffler2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shuffler2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    onShowShufflerMain()
                }
            }
        }
    }
}

@Composable
fun onShowShufflerMain() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var noRepeat by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Text(
            text = "Numbers Chooser",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(12.dp))
        TextField(
            value = amount,
            onValueChange = { if (it.all { char -> char.isDigit() }) amount = it },
            label = { Text("How many numbers to choose?") },
            placeholder = { Text("Type the amount of numbers") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(Modifier.height(12.dp))
        Row() {
            TextField(
                value = number1,
                onValueChange = { if (it.all { char -> char.isDigit() }) number1 = it },
                label = { Text("Input 1") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.width(100.dp)
            )
            Spacer(Modifier.width(12.dp))
            TextField(
                value = number2,
                onValueChange = { if (it.all { char -> char.isDigit() }) number2 = it },
                label = { Text("Input 2") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.width(100.dp)
            )
        }
        Spacer(Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = noRepeat,
                onCheckedChange = { noRepeat = it }
            )
            Text("No repeat")
        }
        Row() {
            Button(onClick = { println("Hello") }) {
                Text("Draw!")
            }
            Spacer(Modifier.width(4.dp))
            Button(onClick = { println("Hello") }) {
                Text("Reset!")
            }
        }
    }
}