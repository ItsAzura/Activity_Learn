package com.example.activity_application

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activity_application.ui.theme.Activity_ApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity_ApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage()
                }
            }
        }
    }
    fun navigateToReceiverActivity(context: Context, dataToSend: String) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("User", dataToSend)
        startActivity(intent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(top = 100.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var textUser by remember{ mutableStateOf("") }
        var textPass by remember{ mutableStateOf("") }
        Text(
            text = "Login",
            fontSize = 30.sp,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp),

        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "User",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )

            val focusRequester = remember { FocusRequester() }
            TextField(
                value = textUser,
                onValueChange = {
                    textUser = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .focusRequester(focusRequester),
                label = { Text("Nhập Tài Khoản") },
            )
        }
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Pass",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )

            val focusRequester = remember { FocusRequester() }
            TextField(
                value = textPass,
                onValueChange = {
                    textPass = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .focusRequester(focusRequester),
                label = { Text("Nhập mật khẩu") },
            )
        }
        val context = LocalContext.current as MainActivity
        Button(
            onClick = {
                Toast.makeText(context, "WellCome ${textUser} ", Toast.LENGTH_SHORT).show()
                context.navigateToReceiverActivity(context, textUser)
            }) {
            Text(text = "Login")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Activity_ApplicationTheme {

    }
}

