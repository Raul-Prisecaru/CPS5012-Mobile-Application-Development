package com.example.data_storage_week_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data_storage_week_6.ui.theme.Data_storage_week_6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferenceIntent = Intent(this, SharedPreference::class.java)
        val interalStorageIntent = Intent(this, InternalStorage::class.java)
        val externalStorageIntent = Intent(this, ExternalStorage::class.java)
        val firebaseIntent = Intent(this, FirebaseActivity::class.java)
        enableEdgeToEdge()
        setContent {
            Data_storage_week_6Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(top = 50.dp)) {
                        Button(onClick = {startActivity(sharedPreferenceIntent)}) {
                            Text(
                                text = "Shared Preference"
                            )
                        }
                        Button(onClick = {startActivity(interalStorageIntent)}) {
                            Text(
                                text = "Internal Storage"
                            )
                        }
                        Button(onClick = {startActivity(externalStorageIntent)}) {
                            Text(
                                text = "External Storage"
                            )
                        }
                        Button(onClick = {startActivity(firebaseIntent)}) {
                            Text(
                                text = "Firebase"
                            )
                        }

                    }
                }
            }
        }
    }
}