package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.google.samples.apps.sunflower.ui.TorangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Column(
                    Modifier.fillMaxSize()
                ) {
                    Text(text = "!!!")
                    Button(
                        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "!!")
                    }
                }
            }
        }
    }
}