package com.example.data_storage_week_6

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data_storage_week_6.ui.theme.Data_storage_week_6Theme

class InternalStorage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Data_storage_week_6Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(top = 100.dp)) {
                        var textFileName by remember { mutableStateOf("") }
                        var textFileContent by remember { mutableStateOf("") }
                        var fileList by remember { mutableStateOf(emptyList<String>()) }
                        Text(
                            text = "Text Editor",
                            fontSize = 50.sp
                            )

                        Text(
                            text = "File Name"
                        )
                        TextField(
                            value = textFileName,
                            onValueChange = {textFileName = it},
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        Text(
                            text = "File Content"
                        )

                        TextField(
                            value = textFileContent,
                            onValueChange = {textFileContent = it},
                            modifier = Modifier
                                .width(430.dp)
                                .height(430.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 70.dp)

                        ) {
                            Button(
                                onClick = {
                                    val fileName = "$textFileName.txt"
                                    val fileContent = textFileContent
                                    openFileOutput(fileName, Context.MODE_PRIVATE).use {
                                        it.write(fileContent.toByteArray())
                                    }
                                    println("File Saved")
                                }) {
                            Text("Save") }

                            Button(onClick = {
                                openFileInput("$textFileName").bufferedReader().use { textFileContent = it.readText() }
                                println("Loaded file")
                            }) {
                                Text("Load")
                            }

                            Button(onClick = {
                                fileList = fileList().toList()
                            }) {
                                Text(
                                    text = "Refresh"
                                )
                            }
                        }

                        LazyRow(
                            modifier = Modifier
                                .padding(end = 10.dp)
//                                .horizontalScroll(rememberScrollState())
                        ) {
                                items(fileList) {file ->
                                    if (file != "profileInstalled") {
                                        Column {
                                            Text(
                                                text=file,
                                                modifier = Modifier.padding(end = 10.dp)
                                            )

                                            Button(onClick = {textFileName = file}) {
                                                Text(
                                                    text = "Load"
                                                )
                                            }
                                        }
                                    }
                                }


                                }
                            }
                        }

                    }
                }

            }

        }