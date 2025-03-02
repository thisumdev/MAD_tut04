package com.example.tutorial_04_android_layouts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial_04_android_layouts.ui.theme.Tutorial04AndroidLayoutsTheme

class MainActivity : ComponentActivity() {
    lateinit var editName:EditText
    lateinit var btnWelcome:Button
    lateinit var btnGoodBye:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editName = findViewById(R.id.editName)
        btnWelcome = findViewById(R.id.btnWelcome)
        btnGoodBye = findViewById(R.id.btnGoodBye)


        fun sayHello(){
            Toast.makeText(this, "Hello, ${editName.text.toString()}", Toast.LENGTH_LONG).show()
        }

        fun sayGoodBye(){
            Toast.makeText(this, "GoodBye, ${editName.text.toString()}", Toast.LENGTH_LONG).show()
        }

        btnWelcome.setOnClickListener{
            sayHello()
        }

        btnGoodBye.setOnClickListener(){
            sayGoodBye()
        }

        enableEdgeToEdge()
        setContent {
            Tutorial04AndroidLayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tutorial04AndroidLayoutsTheme {
        Greeting("Android")
    }
}

