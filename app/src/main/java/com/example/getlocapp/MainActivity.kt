package com.example.getlocapp

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.getlocapp.ui.theme.GetLocAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            1
        )

        setContent {
            GetLocAppTheme {
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }*/
                Column(modifier = Modifier.fillMaxSize()) {
                    Button(onClick = {
                        Intent(applicationContext, LocationService::class.java).apply {
                            action = LocationService.ACTION_START_LOCATION_SERVICE
                            startService(this)
                        }
                    }) {
                        Text(text = "Start")
                    }

                    Button(onClick = {
                        Intent(applicationContext, LocationService::class.java).apply {
                            action = LocationService.ACTION_STOP_LOCATION_SERVICE
                            startService(this)
                        }
                    }) {
                        Text(text = "Stop")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetLocAppTheme {
        Greeting("Android")
    }
}