package com.givfnz.shuffler2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.givfnz.shuffler2.ui.theme.Shuffler2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shuffler2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowShufflerMain()
                }
            }
        }
    }
}

@Composable
fun ShowShufflerMain() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var noRepeat by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(280.dp)) {
                Text("Shuffler2", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Words chooser") },
                    selected = false,
                    onClick = { /* TODO: Go to words chooser */ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Numbers chooser") },
                    selected = true,
                    onClick = { /* TODO: Close drawer */}
                )
            }
        }
    ) {
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(Modifier.height(12.dp))

            Row {
                TextField(
                    value = number1,
                    onValueChange = { if (it.all { char -> char.isDigit() }) number1 = it },
                    label = { Text("Input 1") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(135.dp)
                )
                Spacer(Modifier.width(12.dp))
                TextField(
                    value = number2,
                    onValueChange = { if (it.all { char -> char.isDigit() }) number2 = it },
                    label = { Text("Input 2") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(135.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Checkbox(checked = noRepeat, onCheckedChange = { noRepeat = it })
                Text("No repeat")
            }

            Row {
                Button(onClick = { /* TODO: API Integration */ }) {
                    Text("Draw!")
                }
                Spacer(Modifier.width(8.dp))
                Button(onClick = {
                    number1 = ""; number2 = ""; amount = ""; noRepeat = false
                }) {
                    Text("Reset!")
                }
            }
        }
    }
}