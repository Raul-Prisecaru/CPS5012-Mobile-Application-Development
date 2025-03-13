package com.example.data_storage_week_6

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.data_storage_week_6.databinding.ActivitySharedPreferenceBinding
import com.example.data_storage_week_6.ui.theme.Data_storage_week_6Theme

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Data_storage_week_6Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    var counter = sharedPref.getInt("counter", 0)
                    Column {
                        Text(
                            text = "App",
                            fontSize = 50.sp
                        )

                        Text(
                            text = counter.toString()
                        )

                        Row {
                            Button(onClick = {
                                with(sharedPref.edit()) {
                                    var name = sharedPref.getInt("counter", 0)
                                    putInt("counter", name++)
                                    apply()
                                }
                            }) {
                                Text(
                                    text = "+"
                                )
                            }

//                            Button(onClick = {counter--}) {
//                                Text(
//                                    text = "-"
//                                )
                            }
                        }
                    }




                }
            }
        }
    }
